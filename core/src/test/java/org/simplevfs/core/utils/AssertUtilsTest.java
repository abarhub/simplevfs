package org.simplevfs.core.utils;


import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.simplevfs.core.exception.InvalidParameterException;
import org.simplevfs.core.path.RootName;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

public class AssertUtilsTest {

    @Test
    public void verifyNotNullOK() {
        AssertUtils.verifyNotNull(new Object(),"Test assertion");
    }

    @Test
    public void verifyNotNullKO() {
        final String messageErreur="Test null assertion";
        try {
            AssertUtils.verifyNotNull(null, messageErreur);
            fail("Erreur");
        }catch(NullPointerException e){
            assertEquals(messageErreur,e.getMessage());
        }
    }

    private static Stream<Arguments> provideNotEmptyOK() {
        return Stream.of(
                Arguments.of("abc", "Test not empty assertion"),
                Arguments.of("   abc", "Test not empty assertion2"),
                Arguments.of("abc   ", "Test not empty assertion3")
        );
    }

    @ParameterizedTest
    @MethodSource("provideNotEmptyOK")
    public void verifyNotEmptyOK(String parameterChecked, String messageError) {
        AssertUtils.verifyNotEmpty(parameterChecked,messageError);
    }

    private static Stream<Arguments> provideNotEmptyKO() {
        return Stream.of(
                Arguments.of(null, "Test not empty null assertion"),
                Arguments.of("   ", "Test not empty with space assertion")
        );
    }

    @ParameterizedTest
    @MethodSource("provideNotEmptyKO")
    public void verifyNotEmptyKO(String parameterChecked, String messageError) {
        try {
            AssertUtils.verifyNotEmpty(parameterChecked,messageError);
            fail("Erreur");
        }catch(InvalidParameterException e){
            assertEquals(messageError,e.getMessage());
        }
    }

    @Test
    public void verifyNotEmptySpaceKO() {
        final String messageErreur="Test not empty space assertion";
        try {
            AssertUtils.verifyNotEmpty("    ",messageErreur);
            fail("Erreur");
        }catch(InvalidParameterException e){
            assertEquals(messageErreur,e.getMessage());
        }
    }

    @Test
    public void verifyTrueOK() {
        AssertUtils.verifyTrue(true,"Test true assertion");
    }

    @Test
    public void verifyTrueKO() {
        final String messageErreur="Test false assertion";
        try {
            AssertUtils.verifyTrue(false, messageErreur);
            fail("Erreur");
        }catch(InvalidParameterException e){
            assertEquals(messageErreur,e.getMessage());
        }
    }

    private static Stream<Arguments> provideValideNameOK() {
        return Stream.of(
                Arguments.of("abc", "Test valide name assertion"),
                Arguments.of("abc123", "Test valide name assertion2"),
                Arguments.of("abcabc", "Test valide name assertion3"),
                Arguments.of("ABCABC", "Test valide name assertion4"),
                Arguments.of("AbCaBc", "Test valide name assertion5")
        );
    }

    @ParameterizedTest
    @MethodSource("provideValideNameOK")
    public void verifyValideNameOK(String parameterChecked, String messageError) {
        AssertUtils.verifyValideName(parameterChecked);
    }

    private static Stream<Arguments> provideValideNameKO() {
        return Stream.of(
                Arguments.of("123", "Path Name must star with letter"),
                Arguments.of("1abc", "Path Name must star with letter"),
                Arguments.of("  ", "Path Name must not be empty"),
                Arguments.of("abc123 ", "Path Name must contain only letter or digit"),
                Arguments.of(" ", "Path Name must not be empty"),
                Arguments.of(null, "Path Name must not be empty"),
                Arguments.of("abc 123", "Path Name must contain only letter or digit")
        );
    }

    @ParameterizedTest
    @MethodSource("provideValideNameKO")
    public void verifyValideNameKO(String parameterChecked, String messageError) {
        try {
            AssertUtils.verifyValideName(parameterChecked);
            fail("Erreur");
        }catch(InvalidParameterException e){
            assertEquals(messageError,e.getMessage());
        }
    }
}

package org.simplevfs.core.path;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.simplevfs.core.config.Configuration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;


public class AbsolutePathTest {

    private static final Logger LOGGER = LoggerFactory.getLogger(AbsolutePathTest.class);

    @Test
    public void testConstructor() {
        LOGGER.info("testConstructor");
        final AbsolutePath absolutePath=new AbsolutePath(new RootName("aaa"),"bbb");

        assertEquals(new RootName("aaa"),absolutePath.getName());
        assertEquals("bbb",absolutePath.getPath());
    }

    private static Stream<Arguments> provideAbsolutePathForGetName() {
        return Stream.of(
                Arguments.of(new AbsolutePath(new RootName("aaa1"),"bbb1"), new RootName("aaa1")),
                Arguments.of(new AbsolutePath(new RootName("aaa2"),"bbb2"), new RootName("aaa2"))
        );
    }

    @ParameterizedTest
    @MethodSource("provideAbsolutePathForGetName")
    public void getName(AbsolutePath path,RootName valueRef) {

        assertEquals(valueRef,path.getName());
    }

    private static Stream<Arguments> provideAbsolutePathForGetPath() {
        return Stream.of(
                Arguments.of(new AbsolutePath(new RootName("aaa1"),"bbb1"), "bbb1"),
                Arguments.of(new AbsolutePath(new RootName("aaa2"),"bbb2"), "bbb2")
        );
    }

    @ParameterizedTest
    @MethodSource("provideAbsolutePathForGetPath")
    public void getPath(AbsolutePath path, String valueRef) {
        assertEquals(valueRef,path.getPath());
    }

    @Test
    public void equals1() {

        final AbsolutePath path1=new AbsolutePath(new RootName("aaa"),"bbb");
        final AbsolutePath path2=new AbsolutePath(new RootName("bbb"),"bbb");
        final AbsolutePath path3=new AbsolutePath(new RootName("aaa"),"bbb");

        assertNotEquals(path1,path2);
        assertNotEquals(path2,path1);
        assertEquals(path1,path1);
        assertEquals(path1,path3);
        assertEquals(path3,path1);
    }

    @Test
    public void hashCode1() {
        final AbsolutePath path1=new AbsolutePath(new RootName("aaa"),"bbb");
        final AbsolutePath path2=new AbsolutePath(new RootName("bbb"),"bbb");
        final AbsolutePath path3=new AbsolutePath(new RootName("aaa"),"bbb");

        assertNotEquals(path1.hashCode(),path2.hashCode());
        assertNotEquals(path2.hashCode(),path1.hashCode());
        assertEquals(path1.hashCode(),path1.hashCode());
        assertEquals(path1.hashCode(),path3.hashCode());
        assertEquals(path3.hashCode(),path1.hashCode());
    }
}

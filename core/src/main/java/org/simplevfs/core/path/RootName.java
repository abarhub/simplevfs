package org.simplevfs.core.path;

import org.simplevfs.core.utils.AssertUtils;

import java.util.Objects;

public class RootName {

    private final String name;

    public RootName(String name) {
        AssertUtils.verifyNotEmpty(name,"Name must not be null");
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RootName rootName = (RootName) o;
        return Objects.equals(name, rootName.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    @Override
    public String toString() {
        return "RootName{" +
                "name='" + name + '\'' +
                '}';
    }
}

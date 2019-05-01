package org.simplevfs.core.path;

import org.simplevfs.core.utils.AssertUtils;

import java.util.Objects;

public class AbsolutePath extends AbstractPath {

    private final RootName name;
    private final String path;

    public AbsolutePath(RootName name, String path) {
        AssertUtils.verifyNotNull(name,"Name must not be null");
        AssertUtils.verifyNotNull(path,"Path must not be null");
        this.name = name;
        this.path = path;
    }

    public RootName getName() {
        return name;
    }

    public String getPath() {
        return path;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AbsolutePath that = (AbsolutePath) o;
        return Objects.equals(name, that.name) &&
                Objects.equals(path, that.path);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, path);
    }
}

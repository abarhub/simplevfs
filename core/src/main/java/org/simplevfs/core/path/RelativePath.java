package org.simplevfs.core.path;

import org.simplevfs.core.utils.AssertUtils;

import java.util.Objects;

public class RelativePath extends AbstractPath {

    private final String path;

    public RelativePath(String path) {
        AssertUtils.verifyNotNull(path,"Path must not be null");
        this.path = path;
    }

    public String getPath() {
        return path;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RelativePath that = (RelativePath) o;
        return Objects.equals(path, that.path);
    }

    @Override
    public int hashCode() {
        return Objects.hash(path);
    }
}

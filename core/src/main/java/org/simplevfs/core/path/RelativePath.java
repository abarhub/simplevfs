package org.simplevfs.core.path;

import org.simplevfs.core.utils.AssertUtils;

public class RelativePath extends AbstractPath {

    private final String path;

    public RelativePath(String path) {
        AssertUtils.verifyNotNull(path,"Path must not be null");
        this.path = path;
    }

    public String getPath() {
        return path;
    }
}

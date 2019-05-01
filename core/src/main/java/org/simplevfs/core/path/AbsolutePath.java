package org.simplevfs.core.path;

import org.simplevfs.core.utils.AssertUtils;

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
}

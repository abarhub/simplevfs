package org.simplevfs.core.path;

import org.simplevfs.core.utils.AssertUtils;

public class RootName {

    private final String name;

    public RootName(String name) {
        AssertUtils.verifyNotEmpty(name,"Name must not be null");
        this.name = name;
    }

    public String getName() {
        return name;
    }
}

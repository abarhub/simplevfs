package org.simplevfs.core.rootfs.memoryfs;

import org.simplevfs.core.rootfs.Fs;
import org.simplevfs.core.rootfs.FsCommand;

public class MemoryFs implements Fs {

    @Override
    public FsCommand getFsCommand() {
        return null;
    }
}

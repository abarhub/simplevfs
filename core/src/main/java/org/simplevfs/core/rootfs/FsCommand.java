package org.simplevfs.core.rootfs;

import org.simplevfs.core.path.AbsolutePath;

import java.io.IOException;

public interface FsCommand {

    public void createFile(AbsolutePath path) throws IOException;

}

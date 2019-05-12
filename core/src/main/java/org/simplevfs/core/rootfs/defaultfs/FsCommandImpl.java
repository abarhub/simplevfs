package org.simplevfs.core.rootfs.defaultfs;

import org.simplevfs.core.path.AbsolutePath;
import org.simplevfs.core.path.AbstractPath;
import org.simplevfs.core.rootfs.FsCommand;
import org.simplevfs.core.utils.AssertUtils;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class FsCommandImpl implements FsCommand {

    private final DefaultFs defaultFs;

    public FsCommandImpl(DefaultFs defaultFs) {
        AssertUtils.verifyNotNull(defaultFs,"DefaultFs must not be null");
        this.defaultFs = defaultFs;
    }

    public void createFile(AbsolutePath path) throws IOException {
        AssertUtils.verifyNotNull(path,"Path must not be null");
        Path realPath=defaultFs.getRealPath(path);
        Files.createFile(realPath);
    }
}

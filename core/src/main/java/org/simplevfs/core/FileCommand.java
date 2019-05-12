package org.simplevfs.core;

import org.simplevfs.core.path.AbsolutePath;
import org.simplevfs.core.rootfs.Fs;
import org.simplevfs.core.utils.AssertUtils;

import java.io.IOException;

public class FileCommand {

    final private AbsolutePath absolutePath;
    final private Fs fs;

    public FileCommand(AbsolutePath absolutePath, Fs fs) {
        AssertUtils.verifyNotNull(absolutePath,"Path must not be null");
        AssertUtils.verifyNotNull(fs,"Fs must not be null");
        this.absolutePath = absolutePath;
        this.fs = fs;
    }

    public void copyTo(AbsolutePath dest){

    }

    public void moveTo(AbsolutePath dest){

    }

    public void createDirectories(){

    }

    public void createDirectory(){

    }

    public void createFile() throws IOException {
        fs.getFsCommand().createFile(absolutePath);
    }

    public void delete(){

    }

    public void deleteIfExists(){

    }
}

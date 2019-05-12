package org.simplevfs.core;

import org.simplevfs.core.path.AbsolutePath;

import java.nio.file.attribute.FileAttributeView;
import java.nio.file.attribute.FileTime;
import java.nio.file.attribute.PosixFilePermission;
import java.nio.file.attribute.UserPrincipal;
import java.util.Map;
import java.util.Set;

public class FileView {

    public boolean exists(AbsolutePath path){
        return false;
    }

    public FileTime getLastModifiedTime(AbsolutePath path){
        return null;
    }

    public boolean isDirectory(AbsolutePath path){
        return false;
    }

    public boolean isExecutable(AbsolutePath path){
        return false;
    }

    public boolean isHidden(AbsolutePath path){
        return false;
    }

    public boolean isReadable​(AbsolutePath path){
        return false;
    }

    public boolean isRegularFile(AbsolutePath path){
        return false;
    }

    public boolean isSameFile(AbsolutePath path,AbsolutePath otherPath){
        return false;
    }

    public boolean isSymbolicLink​(AbsolutePath path){
        return false;
    }

    public boolean isWritable(AbsolutePath path){
        return false;
    }

    public boolean notExists(AbsolutePath path){
        return false;
    }

    public long size(AbsolutePath path){
        return 0;
    }
}

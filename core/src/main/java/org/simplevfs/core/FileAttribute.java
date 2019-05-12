package org.simplevfs.core;

import org.simplevfs.core.path.AbsolutePath;

import java.nio.file.attribute.FileAttributeView;
import java.nio.file.attribute.PosixFilePermission;
import java.nio.file.attribute.UserPrincipal;
import java.util.Map;
import java.util.Set;

public class FileAttribute {


    public UserPrincipal getOwner(AbsolutePath path){
        return null;
    }

    public Object getAttribute(AbsolutePath path){
        return null;
    }

    public <V extends FileAttributeView> V getFileAttributeView(AbsolutePath path){
        return null;
    }

    public Set<PosixFilePermission> getPosixFilePermissions​(AbsolutePath path){
        return null;
    }

    public Map readAttributes(AbsolutePath path){
        return null;
    }
}

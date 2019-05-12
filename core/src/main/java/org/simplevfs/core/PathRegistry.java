package org.simplevfs.core;

import org.simplevfs.core.path.AbsolutePath;
import org.simplevfs.core.path.RelativePath;
import org.simplevfs.core.path.RootName;

public class PathRegistry {

    public RootName getName(String name){
        return new RootName(name);
    }

    public AbsolutePath getAbsolutePath(RootName name, String path){
        return new AbsolutePath(name,path);
    }

    public RelativePath getRelativePath(String path){
        return new RelativePath(path);
    }
}

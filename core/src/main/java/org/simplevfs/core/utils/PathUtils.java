package org.simplevfs.core.utils;

import org.simplevfs.core.path.AbsolutePath;
import org.simplevfs.core.path.RelativePath;

import java.io.File;

public class PathUtils {

    public static AbsolutePath getPath(AbsolutePath path, RelativePath... relativePaths){
        if(relativePaths==null||relativePaths.length==0){
            return path;
        } else {
            String pathFinal="";
            if(!path.getPath().isEmpty()){
                pathFinal+=path.getPath();
            }
            if(relativePaths.length>0){
                for(RelativePath relativePath:relativePaths){
                    if(!relativePath.getPath().isEmpty()){
                        if(!pathFinal.isEmpty()){
                            pathFinal+=getSeparator();
                        }
                        pathFinal+=relativePath.getPath();
                    }
                }
            }
            return new AbsolutePath(path.getName(),pathFinal);
        }
    }

    public static String getSeparator(){
        return File.separator;
    }
}

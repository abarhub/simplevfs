package org.simplevfs.core.utils;

import org.simplevfs.core.path.AbsolutePath;
import org.simplevfs.core.path.RelativePath;

import java.io.File;

public class PathUtils {

    public static AbsolutePath getPath(AbsolutePath path, RelativePath... relativePaths){
        if(relativePaths==null||relativePaths.length==0){
            return path;
        } else {
            StringBuilder pathFinal= new StringBuilder();
            if(!path.getPath().isEmpty()){
                pathFinal.append(path.getPath());
            }
            for(RelativePath relativePath:relativePaths){
                if(!relativePath.getPath().isEmpty()){
                    if(pathFinal.length() > 0){
                        pathFinal.append(getSeparator());
                    }
                    pathFinal.append(relativePath.getPath());
                }
            }
            return new AbsolutePath(path.getName(), pathFinal.toString());
        }
    }

    public static String getSeparator(){
        return File.separator;
    }
}

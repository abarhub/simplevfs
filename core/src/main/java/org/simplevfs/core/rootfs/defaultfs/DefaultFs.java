package org.simplevfs.core.rootfs.defaultfs;

import org.simplevfs.core.config.ConfigPath;
import org.simplevfs.core.path.AbsolutePath;
import org.simplevfs.core.path.AbstractPath;
import org.simplevfs.core.path.RootName;
import org.simplevfs.core.rootfs.Fs;
import org.simplevfs.core.rootfs.FsCommand;
import org.simplevfs.core.utils.AssertUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;

public class DefaultFs implements Fs {

    private static final Logger LOGGER = LoggerFactory.getLogger(DefaultFs.class);

    private final Map<RootName, ConfigPath> mapPath;
    private final FsCommand fsCommand;


    public DefaultFs() {
        mapPath=new HashMap<>();
        fsCommand=new FsCommandImpl(this);
    }

    public void addPath(RootName name, ConfigPath configPath){
        AssertUtils.verifyNotNull(name,"Name must not be null");
        AssertUtils.verifyNotNull(configPath,"ConfigPath must not be null");
        AssertUtils.verifyTrue(!mapPath.containsKey(name),"Name already exist");
        mapPath.put(name,configPath);
    }


    public void removePath(RootName name){
        AssertUtils.verifyNotNull(name,"Name must not be null");
        AssertUtils.verifyTrue(mapPath.containsKey(name),"Name not exist");
        LOGGER.debug("removePath {}",name);
        mapPath.remove(name);
    }

    @Override
    public FsCommand getFsCommand() {
        return fsCommand;
    }

    public Path getRealPath(AbsolutePath path){
        AssertUtils.verifyNotNull(path,"Path must not be null");
        RootName name = path.getName();
        ConfigPath configPath = mapPath.get(name);
        String rootPath=configPath.getPath();
        Path p=Paths.get(path.getPath());
        p=p.normalize();
        return Paths.get(rootPath,p.toString());
    }
}

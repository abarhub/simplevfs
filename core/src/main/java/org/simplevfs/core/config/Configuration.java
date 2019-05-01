package org.simplevfs.core.config;

import org.simplevfs.core.path.RootName;
import org.simplevfs.core.utils.AssertUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.Map;

public class Configuration {

    private static final Logger LOGGER = LoggerFactory.getLogger(Configuration.class);

    private final Map<RootName,ConfigPath> mapPath;

    public Configuration() {
        mapPath = new HashMap<>();
    }

    public void addPath(RootName name,ConfigPath configPath){
        AssertUtils.verifyNotNull(name,"Name must not be null");
        AssertUtils.verifyNotNull(configPath,"ConfigPath must not be null");
        AssertUtils.verifyTrue(!mapPath.containsKey(name),"Name already exist");
        LOGGER.debug("addPath {}",name);
        mapPath.put(name,configPath);
    }

    public void removePath(RootName name){
        AssertUtils.verifyNotNull(name,"Name must not be null");
        AssertUtils.verifyTrue(mapPath.containsKey(name),"Name not exist");
        LOGGER.debug("removePath {}",name);
        mapPath.remove(name);
    }

    public boolean existPath(RootName name){
        AssertUtils.verifyNotNull(name,"Name must not be null");
        return mapPath.containsKey(name);
    }
}

package org.simplevfs.core.config;

import org.simplevfs.core.utils.AssertUtils;

import java.util.*;

public class ConfigPath {

    private final String path;
    private final String implementation;
    private final Map<String,String> parameters;

    public ConfigPath(String path, String implementation, Map<String,String> parameters) {
        AssertUtils.verifyNotEmpty(implementation,"Implementation must not be null");
        if(path==null){
            this.path ="";
        } else {
            this.path = path;
        }
        this.implementation=implementation;
        if(parameters==null){
            this.parameters = Collections.emptyMap();
        } else {
            Map<String,String> parametersCopy=new HashMap<>(parameters);
            this.parameters = Collections.unmodifiableMap(parametersCopy);
        }
    }

    public String getPath() {
        return path;
    }

    public String getImplementation() {
        return implementation;
    }

    public Map<String, String> getParameters() {
        return parameters;
    }
}

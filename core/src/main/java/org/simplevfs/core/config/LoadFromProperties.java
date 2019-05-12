package org.simplevfs.core.config;

import org.simplevfs.core.exception.ConfigurationException;
import org.simplevfs.core.utils.AssertUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.Reader;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class LoadFromProperties {

    private static final Logger LOGGER = LoggerFactory.getLogger(LoadFromProperties.class);

    public Configuration load(Path file) throws IOException, ConfigurationException {
        AssertUtils.verifyNotNull(file,"File must not be null");
        Properties properties=new Properties();
        try(Reader reader=Files.newBufferedReader(file,StandardCharsets.UTF_8)) {
            properties.load(reader);
        }
        Configuration configuration=new Configuration();

        Map<String,String> map=convertProperties(properties);


        return configuration;
    }

    private Map<String, String> convertProperties(Properties properties) throws ConfigurationException {
        Map<String,String> map=new HashMap<>();

        Enumeration<Object> propertiesName= (Enumeration<Object>) properties.propertyNames();

        if(propertiesName!=null){
            while(propertiesName.hasMoreElements()){
                Object o=propertiesName.nextElement();
                if(o instanceof String){
                    String name= (String) o;
                    if(map.containsKey(name)){
                        throw new ConfigurationException("Name '"+name+"' is duplicated");
                    }
                    map.put(name,properties.getProperty(name));
                } else {
                    throw new ConfigurationException("Name is not String");
                }
            }
        }

        return map;
    }
}

package org.simplevfs.core.config;

import org.simplevfs.core.exception.ConfigurationException;
import org.simplevfs.core.path.RootName;
import org.simplevfs.core.utils.AssertUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.FileReader;
import java.io.IOException;
import java.io.StringReader;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.Map;

import javax.json.*;

public class LoadFromJson {


    private static final Logger LOGGER = LoggerFactory.getLogger(LoadFromJson.class);

    public Configuration load(Path file) throws IOException, ConfigurationException {
        AssertUtils.verifyNotNull(file,"File must not be null");

        Configuration configuration=new Configuration();

        try(JsonReader reader = Json.createReader(Files.newBufferedReader(file, StandardCharsets.UTF_8))){

            JsonObject rootObject = reader.readObject();

            JsonArray config = rootObject.getJsonArray("config");

            if(config!=null&&!config.isEmpty()){

                for(int i=0;i<config.size();i++){
                    JsonObject val = config.getJsonObject(i);

                    JsonString name = val.getJsonString("name");
                    JsonString path = val.getJsonString("path");
                    JsonString implementation = val.getJsonString("implementation");
                    JsonObject parameters = val.getJsonObject("parameters");

                    Map<String,String> parameter=new HashMap<>();
                    if(parameters!=null){
                        for(String key:parameters.keySet()){
                            JsonString value=parameters.getJsonString(key);
                            parameter.put(key,value.getString());
                        }
                    }

                    ConfigPath configPath=new ConfigPath(path.getString(),implementation.getString(),parameter);

                    configuration.addPath(new RootName(name.getString()),configPath);
                }

            }
        }

        return configuration;
    }
}

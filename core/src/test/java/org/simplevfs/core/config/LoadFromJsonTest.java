package org.simplevfs.core.config;


import org.junit.jupiter.api.Test;
import org.simplevfs.core.exception.ConfigurationException;
import org.simplevfs.core.path.AbsolutePathTest;
import org.simplevfs.core.path.RootName;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class LoadFromJsonTest {

    private static final Logger LOGGER = LoggerFactory.getLogger(LoadFromJsonTest.class);

    @Test
    public void load() throws IOException, ConfigurationException, URISyntaxException {
        LOGGER.info("load");

        Path p=getFile("configtest/configtest1.json");
        LOGGER.info("p={}",p);

        LoadFromJson loadFromJson=new LoadFromJson();
        Configuration res = loadFromJson.load(p);

        assertNotNull(res);

        List<RootName> rootNames=res.getRoots();
        assertNotNull(rootNames);
        assertEquals(3,rootNames.size());
        assertTrue(rootNames.contains(getRootName("aaa")));
        assertTrue(rootNames.contains(getRootName("aaa2")));
        assertTrue(rootNames.contains(getRootName("aaa3")));
        assertTrue(res.existPath(getRootName("aaa")));
        assertTrue(res.existPath(getRootName("aaa2")));
        assertTrue(res.existPath(getRootName("aaa3")));

        // config 1
        final ConfigPath config1 = res.getConfigPath(getRootName("aaa"));
        assertNotNull(config1);
        assertEquals("bbb", config1.getPath());
        assertEquals("ccc", config1.getImplementation());
        assertNotNull(config1.getParameters());
        assertEquals(3, config1.getParameters().size());
        assertEquals("xxx", config1.getParameters().get("param1"));
        assertEquals("yyy", config1.getParameters().get("param2"));
        assertEquals("zzz", config1.getParameters().get("param3"));

        // config 2
        final ConfigPath config2 = res.getConfigPath(getRootName("aaa2"));
        assertNotNull(config2);
        assertEquals("bbb2", config2.getPath());
        assertEquals("ccc2", config2.getImplementation());
        assertNotNull(config2.getParameters());
        assertEquals(3, config2.getParameters().size());
        assertEquals("xxx2", config2.getParameters().get("param1"));
        assertEquals("yyy2", config2.getParameters().get("param2"));
        assertEquals("zzz2", config2.getParameters().get("param3"));

        // config 3
        final ConfigPath config3 = res.getConfigPath(getRootName("aaa3"));
        assertNotNull(config3);
        assertEquals("bbb3", config3.getPath());
        assertEquals("ccc3", config3.getImplementation());
        assertNotNull(config3.getParameters());
        assertEquals(3, config3.getParameters().size());
        assertEquals("xxx3", config3.getParameters().get("param1"));
        assertEquals("yyy3", config3.getParameters().get("param2"));
        assertEquals("zzz3", config3.getParameters().get("param3"));
    }

    @Test
    public void loadEmpty() throws IOException, ConfigurationException, URISyntaxException {
        LOGGER.info("loadEmpty");

        Path p=getFile("configtest/configtest2.json");
        LOGGER.info("p={}",p);

        LoadFromJson loadFromJson=new LoadFromJson();
        Configuration res = loadFromJson.load(p);

        assertNotNull(res);

        List<RootName> rootNames=res.getRoots();
        assertNotNull(rootNames);
        assertEquals(0,rootNames.size());
    }

    @Test
    public void load3() throws IOException, ConfigurationException, URISyntaxException {
        LOGGER.info("load3");

        Path p=getFile("configtest/configtest3.json");
        LOGGER.info("p={}",p);

        LoadFromJson loadFromJson=new LoadFromJson();
        Configuration res = loadFromJson.load(p);

        assertNotNull(res);

        List<RootName> rootNames=res.getRoots();
        assertNotNull(rootNames);
        assertEquals(2,rootNames.size());
        assertTrue(rootNames.contains(getRootName("aaa01")));
        assertTrue(rootNames.contains(getRootName("aaa02")));
        assertTrue(res.existPath(getRootName("aaa01")));
        assertTrue(res.existPath(getRootName("aaa02")));

        // config 1
        final ConfigPath config1 = res.getConfigPath(getRootName("aaa01"));
        assertNotNull(config1);
        assertEquals("bbb01", config1.getPath());
        assertEquals("ccc01", config1.getImplementation());
        assertNotNull(config1.getParameters());
        assertEquals(1, config1.getParameters().size());
        assertEquals("xxx01", config1.getParameters().get("param1"));

        // config 2
        final ConfigPath config2 = res.getConfigPath(getRootName("aaa02"));
        assertNotNull(config2);
        assertEquals("bbb02", config2.getPath());
        assertEquals("ccc02", config2.getImplementation());
        assertNotNull(config2.getParameters());
        assertEquals(0, config2.getParameters().size());
    }

    // utility method

    private Path getFile(String testFile) throws URISyntaxException {
        return Paths.get(getClass().getClassLoader().getResource(testFile).toURI());
    }

    private RootName getRootName(String rootName){
        return new RootName(rootName);
    }
}

package com.amazon.test.utility;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Map;
import java.util.Properties;

public class ConfigReader {

    private final Properties properties;
    private static final Logger logger = LoggerFactory.getLogger(ConfigReader.class);

    public ConfigReader() {
        properties = new Properties();
        try (FileInputStream fs = new FileInputStream("src/main/resources/config.properties")) {
            properties.load(fs);
            logger.warn("Loaded properties: " + properties.size() + " entries");
            for (Map.Entry<Object, Object> entry : properties.entrySet()) {
                System.out.println(entry.getKey() + " = " + entry.getValue());
            }
        } catch (IOException e) {
            logger.error("Can't load config.properties", e);
        }
    }

    public String getProperty(String key) {
        return properties.getProperty(key);
    }

    public Properties getProperties() {
        return properties;
    }
}

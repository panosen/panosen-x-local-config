package com.panosen.localconfig;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class MapConfig extends LocalConfig {

    private Logger logger = LoggerFactory.getLogger(MapConfig.class);

    private Map<String, String> map;

    public MapConfig(String fileName) {
        super(fileName);
    }

    public String getStringOrDefault(String key, String defaultValue) {
        if (map != null) {
            return map.getOrDefault(key, defaultValue);
        }
        map = buildMap();
        return map.getOrDefault(key, defaultValue);
    }

    public Integer getIntOrDefault(String key, Integer defaultValue) {
        String value = getStringOrDefault(key, null);
        if (value == null) {
            return defaultValue;
        }
        return Integer.parseInt(value);
    }

    public Long getLongOrDefault(String key, Long defaultValue) {
        String value = getStringOrDefault(key, null);
        if (value == null) {
            return defaultValue;
        }
        return Long.parseLong(value);
    }

    private Map<String, String> buildMap() {
        HashMap<String, String> map = new HashMap<>();
        try {
            InputStream inputStream = getInputStream();
            if (inputStream == null) {
                return map;
            }
            Properties properties = new Properties();
            properties.load(inputStream);
            for (Map.Entry<Object, Object> objectObjectEntry : properties.entrySet()) {
                map.put(objectObjectEntry.getKey().toString(), objectObjectEntry.getValue().toString());
            }
            return map;
        } catch (IOException e) {
            logger.error("buildMap", e);
            return map;
        }
    }
}

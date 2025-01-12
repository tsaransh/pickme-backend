package com.pickme.configuration;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Getter;
import org.springframework.boot.context.config.ConfigData;
import org.springframework.core.io.ClassPathResource;

import java.io.InputStream;

@Getter
public class JsonConfig {

    private static final String filePath = "static/ApplicationConfiguration.json";

    private static ConfigData configData;

    public JsonConfig() {
        configData = readConfig();
    }

    public static ConfigData readConfig() {
        try {
            ObjectMapper mapper = new ObjectMapper();

            ClassPathResource resource = new ClassPathResource( filePath);
            InputStream stream = resource.getInputStream();

            return mapper.readValue(stream, ConfigData.class);
        } catch(Exception ex) {
            throw new IllegalArgumentException(ex.getMessage());
        }
    }
}

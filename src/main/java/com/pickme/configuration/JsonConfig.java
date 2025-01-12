package com.pickme.configuration;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Getter;
import org.springframework.boot.context.config.ConfigData;
import org.springframework.core.io.ClassPathResource;

import java.io.InputStream;

@Getter
public class JsonConfig {

    private static final String CONFIG_File_Path = "static/ApplicationConfiguration.json";

    public static ConfigData configData;

    public static void loadConfig() {
        configData = readConfig();
    }

    private static ConfigData readConfig() {
        try {
            ObjectMapper mapper = new ObjectMapper();

            ClassPathResource resource = new ClassPathResource(CONFIG_File_Path);
            InputStream stream = resource.getInputStream();

            return mapper.readValue(stream, ConfigData.class);
        } catch(Exception ex) {
            throw new IllegalArgumentException(ex.getMessage());
        }
    }
}

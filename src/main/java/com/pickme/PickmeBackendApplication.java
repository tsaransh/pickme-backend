package com.pickme;

import com.pickme.configuration.JsonConfig;
import com.pickme.exceptions.ConfigException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpStatus;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import java.util.logging.Logger;

@SpringBootApplication
@EnableScheduling
@Slf4j
public class PickmeBackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(PickmeBackendApplication.class, args);
	}

	@Scheduled(fixedRate = 1200000) // 20 minutes in milliseconds
	public void loadConfigPeriodically() {
		try {
			log.info("Starting to load config...");
			JsonConfig.loadConfig();
			log.info("Config loaded successfully.");
		} catch (RuntimeException e) {
			throw new ConfigException("Can't able to read config", HttpStatus.BAD_REQUEST);
		}
	}

}

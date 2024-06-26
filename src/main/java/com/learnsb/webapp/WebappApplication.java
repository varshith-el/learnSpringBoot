package com.learnsb.webapp;

import com.learnsb.webapp.config.contentCalenderProperties;
import com.learnsb.webapp.model.Content;
import com.learnsb.webapp.model.Status;
import com.learnsb.webapp.model.Type;
import com.learnsb.webapp.repository.ContentRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;

import java.time.LocalDateTime;

@SpringBootApplication
@EnableConfigurationProperties(contentCalenderProperties.class)
public class WebappApplication {

	public static void main(String[] args) {
		SpringApplication.run(WebappApplication.class, args);
	}


}

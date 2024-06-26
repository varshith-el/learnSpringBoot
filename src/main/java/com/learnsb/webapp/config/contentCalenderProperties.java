package com.learnsb.webapp.config;


import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(value = "cc")
public record contentCalenderProperties(String welcomeMessage, String about) {

}

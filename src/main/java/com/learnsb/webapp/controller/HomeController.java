package com.learnsb.webapp.controller;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;
import org.springframework.boot.context.properties.ConfigurationProperties;
import com.learnsb.webapp.config.contentCalenderProperties;
@RestController
public class HomeController {

    private final contentCalenderProperties properties;

    public HomeController(contentCalenderProperties properties){
        this.properties = properties;
    }

    @GetMapping("/")
    public contentCalenderProperties home(){
        return properties;
    }
}

package com.learnsb.webapp.config;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.learnsb.webapp.model.Content;
import com.learnsb.webapp.repository.ContentRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.io.InputStream;
import java.util.List;

@Component
public class dataLoader implements CommandLineRunner {

    private final ContentRepository repository;
    private final ObjectMapper objectMapper;

    public dataLoader(ContentRepository repository, ObjectMapper objectMapper) {
        this.repository = repository;
        this.objectMapper = objectMapper;
    }

    @Override
    public void run(String... args) throws Exception {
        if(repository.count() == 0) {
            try (InputStream inputStream = TypeReference.class.getResourceAsStream("/data/content.json")) {
                repository.saveAll(objectMapper.readValue(inputStream,new TypeReference<List<Content>>(){}));
            }
        }
    }

}
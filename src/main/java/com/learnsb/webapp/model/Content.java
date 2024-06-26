package com.learnsb.webapp.model;
import java.time.LocalDateTime;

import jakarta.validation.constraints.NotBlank;
import org.springframework.data.annotation.Id;


public record Content(
    @Id
    Integer id,
    @NotBlank
    String title,
    String description,
    Status status,
    Type contentType,
    LocalDateTime dateCreated,
    LocalDateTime dateUpdated,
    String url)
{
}

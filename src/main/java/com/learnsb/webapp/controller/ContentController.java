package com.learnsb.webapp.controller;
import com.learnsb.webapp.model.Status;
import com.learnsb.webapp.model.Type;
import com.learnsb.webapp.repository.ContentCollectionRepository;
import com.learnsb.webapp.repository.ContentRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import com.learnsb.webapp.model.Content;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/api/content")
@CrossOrigin
public class ContentController {

    private final ContentRepository repository;

    @Autowired
    public ContentController(ContentRepository repository){
        this.repository = repository;
    }

    @GetMapping("/all")
    public List<Content> findAll(){
        return repository.findAll();
    }

    @GetMapping("/{id}")
    public Content findById(@PathVariable Integer id){
        return repository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,"Content Not Found"));
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("")
    public void create(@Valid @RequestBody Content content){
        repository.save(content);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PutMapping("/{id}")
    public void update(@RequestBody Content content,@PathVariable Integer id){
        if(!repository.existsById(id)){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"Content Not Found");
        }
        repository.save(content);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id){
        repository.deleteById(id);
    }

    @GetMapping("/search/{keyword}")
    public List<Content> findByTitle(@PathVariable String keyword){
        return repository.findAllByTitleContains(keyword);
    }

    @GetMapping("/search/status/{status}")
    public List<Content> findByStatus(@PathVariable Status status){
        return repository.listByStatus(status);
    }


}

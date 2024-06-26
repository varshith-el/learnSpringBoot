package com.learnsb.webapp.repository;
import java.time.LocalDateTime;
import java.util.ArrayList;

import com.learnsb.webapp.model.Content;
import com.learnsb.webapp.model.Status;
import com.learnsb.webapp.model.Type;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class ContentCollectionRepository {

    private final List<Content> contentList = new ArrayList<>();

    public ContentCollectionRepository(){

    }

    public List<Content> findAll(){
        return contentList;
    }

    public Optional<Content> findById(Integer id){
        return contentList.stream().filter(c -> c.id().equals(id)).findFirst();
    }

    @PostConstruct
    private void init(){
        Content c = new Content(1,
                "My First Blog Post",
                "My First Blog Post",
                Status.IDEA,
                Type.ARTICLE,
                LocalDateTime.now(),
                null,
                "example.com"
        );
        contentList.add(c);
    }

    public void save(Content content){
        contentList.removeIf(c -> c.id().equals(content.id()));
        contentList.add(content);
    }

    public boolean existsById(Integer id){
        return contentList.stream().filter(c -> c.id().equals(id)).count() == 1;
    }

    public void delete(Integer id){
        contentList.removeIf(c -> c.id().equals(id));
    }
}

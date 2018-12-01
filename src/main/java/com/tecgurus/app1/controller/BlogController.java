package com.tecgurus.app1.controller;

import java.util.List;

import com.tecgurus.app1.dto.BlogDTO;
import com.tecgurus.app1.persistence.model.Blog;
import com.tecgurus.app1.service.BlogService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import lombok.*;

@RestController
@RequestMapping("/blogs")
public class BlogController {

    @Setter(onMethod = @__(@Autowired))
    private BlogService blogService;

    @GetMapping
    public List<BlogDTO> findAll() {
        return blogService.findAllBlogs();
    }

    @GetMapping("/byOwner/{ownerName}")
    public List<BlogDTO> findByOwner(@PathVariable/*("ownerName")*/ String ownerName) {
        return blogService.findByOwner(ownerName);
    }


}
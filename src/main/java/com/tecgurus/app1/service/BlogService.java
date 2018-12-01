package com.tecgurus.app1.service;

import java.util.List;
import java.util.stream.Collectors;

import com.tecgurus.app1.dto.BlogDTO;
import com.tecgurus.app1.persistence.model.Blog;
import com.tecgurus.app1.persistence.repository.BlogRepo;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

//import org.springframework.lang.NonNull;
//import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Service
// Tercera forma
//@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class BlogService {

    // Cuarta forma
    @Setter(onMethod = @__(@Autowired))
    private BlogRepo blogRepo;

    @Setter(onMethod = @__(@Autowired))
    private ModelMapper modelMapper;

    // Tercera forma
    //@NonNull
    //private final BlogRepo blogRepo;

    /* Primera forma
    @Autowired
    public BlogService(BlogRepo blogRepo) {
        this.blogRepo = blogRepo;
    }
    */

    /* Segunda forma
    @Autowired
    public void setBlogRepo(BlogRepo blogRepo) {
        this.blogRepo = blogRepo;
    }
    */

    public List<BlogDTO> findAllBlogs() {
        return blogRepo.findAll().stream()
                    .map(blog -> modelMapper.map(blog, BlogDTO.class))
                    .collect(Collectors.toList());
    }

    public List<BlogDTO> findByOwner(String ownerName) {
        return blogRepo.findByOwner(ownerName).stream()
                    .map(blog -> modelMapper.map(blog, BlogDTO.class))
                    .collect(Collectors.toList());
    }

}
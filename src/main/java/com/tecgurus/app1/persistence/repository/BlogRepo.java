package com.tecgurus.app1.persistence.repository;

import java.util.List;

import com.tecgurus.app1.persistence.model.Blog;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BlogRepo extends JpaRepository<Blog, Long> {

    List<Blog> findByOwner(String owner);

}
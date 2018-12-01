package com.tecgurus.app1.persistence.model;

import java.util.*;
import javax.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "Blog")
public class Blog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String owner;

    @OneToMany(mappedBy = "blog", cascade = CascadeType.ALL)
    private List<Post> posts;

}
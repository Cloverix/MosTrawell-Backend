package org.example.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Set;

@Data
@Entity
@Table(name = "tag")
public class Tag {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToMany(mappedBy = "tags")
    private Set<User> users;

    @ManyToMany(mappedBy = "tags")
    private Set<Landmark> landmarks;

    @Column(name = "name", nullable = false, unique = true)
    private String name;
}

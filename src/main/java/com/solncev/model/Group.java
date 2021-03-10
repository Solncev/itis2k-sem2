package com.solncev.model;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity(name = "groups")
@Data
public class Group {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private String name;

    @ManyToMany(mappedBy = "groups")
    private List<User> users;
}

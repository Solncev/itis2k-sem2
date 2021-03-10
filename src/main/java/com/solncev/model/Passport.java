package com.solncev.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Passport {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private Integer series;

    @Column(nullable = false)
    private Integer number;

    @OneToOne(mappedBy = "passport")
    private User user;
}

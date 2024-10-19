package com.guardians.user.service.entities;


import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
public class User {

    @Id
    private String userId;
    @Column(name = "name", length = 15)
    private String name;
    @Column(name="email")
    private String email;
    @Column(name="about")
    private String about;

    @Transient
    private List<Rating> ratings = new ArrayList<>();



}

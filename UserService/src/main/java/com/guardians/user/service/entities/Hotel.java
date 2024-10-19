package com.guardians.user.service.entities;


import lombok.Data;
import org.springframework.http.ResponseEntity;

@Data
public class Hotel{
    private String id;
    private String name;
    private String location;
    private String about;
}

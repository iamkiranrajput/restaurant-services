package com.guardians.user.service.services;

import com.guardians.user.service.entities.User;

import java.util.List;


public interface UserService {
    User saveUser(User user);
    List<User> getAllUser();
    User getUser(String userId);
}

package com.lcwd.user.service.servies;

import java.util.List;

import com.lcwd.user.service.entities.User;

public interface UserService {
    
    User saveUser(User user);

    List<User> getAllUser();

    User getUser(String userId);

    void deleteUser(String userId);

    // User updateUser(String userId, User user);
}

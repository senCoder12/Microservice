package com.lcwd.user.service.servies.impl;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lcwd.user.service.entities.User;
import com.lcwd.user.service.exceptions.ResourceNotFoundException;
import com.lcwd.user.service.reposistories.UserReposistory;
import com.lcwd.user.service.servies.UserService;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserReposistory userReposistory;

    @Override
    public User saveUser(User user) {
        String randomUserId = UUID.randomUUID().toString();
        user.setUserId(randomUserId);
        return userReposistory.save(user);
    }

    @Override
    public List<User> getAllUser() {
        return userReposistory.findAll();
    }

    @Override
    public User getUser(String userId) {
        return userReposistory.findById(userId).orElseThrow( () -> 
                new ResourceNotFoundException("User with id " + userId + " not found on server !!"));
    }

    @Override
    public void deleteUser(String userId) {
        userReposistory.deleteById(userId);
    }

    // @Override
    // public User updateUser(String userId, User user) {
    //     User user2 = userReposistory.updateUser(userId, user);
    //     return user2;
    // }
    
}

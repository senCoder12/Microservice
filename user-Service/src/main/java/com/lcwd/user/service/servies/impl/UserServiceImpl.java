package com.lcwd.user.service.servies.impl;

import java.util.*;
import java.util.stream.Collectors;

import com.lcwd.user.service.entities.Hotel;
import com.lcwd.user.service.entities.Rating;
import com.lcwd.user.service.external.services.HotelService;
import com.lcwd.user.service.external.services.RatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.lcwd.user.service.entities.User;
import com.lcwd.user.service.exceptions.ResourceNotFoundException;
import com.lcwd.user.service.reposistories.UserReposistory;
import com.lcwd.user.service.servies.UserService;
import org.springframework.web.client.RestTemplate;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserReposistory userReposistory;

    @Autowired
    private HotelService hotelService;

    @Autowired
    private RatingService ratingService;

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
        User user = userReposistory.findById(userId).orElseThrow( () ->
                new ResourceNotFoundException("User with id " + userId + " not found on server !!"));

        List<Rating> ratingsOfUser
                = ratingService.getRatings(user.getUserId());

        List<Rating> ratingList = ratingsOfUser.stream()
                .map(rat -> {
                    Hotel hotel = hotelService.getHotel(rat.getHotelId());
                    rat.setHotel(hotel);
                    return rat;
                })
                .collect(Collectors.toList());

        user.setRatings(ratingList);
        return user;
    }

    @Override
    public void deleteUser(String userId) {
        userReposistory.deleteById(userId);
    }

    @Override
    public User updateUser(String userId, User user) {
        User newUser = userReposistory.findById(userId).get();
        if(!"".equals(userId) && Objects.nonNull(userId)) {
            newUser.setUserId(userId);
        }
        if(Objects.nonNull(user.getName()) && !"".equals(user.getName())) {
            newUser.setName(user.getName());
        }

        if(Objects.nonNull(user.getEmail()) && !"".equals(user.getEmail())) {
            newUser.setEmail(user.getEmail());
        }

        if(Objects.nonNull(user.getAbout()) && !"".equals(user.getAbout())) {
            newUser.setAbout(user.getAbout());
        }
        return userReposistory.save(newUser);
    }
    
}

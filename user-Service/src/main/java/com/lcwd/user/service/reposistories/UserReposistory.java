package com.lcwd.user.service.reposistories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.lcwd.user.service.entities.User;

public interface UserReposistory extends JpaRepository<User, String>{

    // Update user
    // @Query("UPDATE User u SET u.name =:user.name, u.email =:user.email WHERE u.id =:userId")
    // User updateUser(String userId, User user);
}

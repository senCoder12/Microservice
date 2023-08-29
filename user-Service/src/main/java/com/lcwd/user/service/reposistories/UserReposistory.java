package com.lcwd.user.service.reposistories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lcwd.user.service.entities.User;

public interface UserReposistory extends JpaRepository<User, String>{

}

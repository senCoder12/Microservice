package com.lcwd.user.service.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "micro_users")
public class User {
    
    @Id
    @Column(name = "ID")
    private String userId;

    @Column(name = "Name", length = 20)
    private String name;

    @Column(name = "Email")
    private String email;

    private String about;

    @Transient
    private List<Rating> ratings = new ArrayList<>();
}
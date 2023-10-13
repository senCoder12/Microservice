package com.lcwd.user.service.entities;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Rating {

    private String ratingId;

    private  String hotelId;

    private String userId;

    private String rating;

    private String feedback;

    private Hotel hotel;
}

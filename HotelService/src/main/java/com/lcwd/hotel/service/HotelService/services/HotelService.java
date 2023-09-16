package com.lcwd.hotel.service.HotelService.services;

import java.util.List;

import com.lcwd.hotel.service.HotelService.entities.Hotel;

public interface HotelService {
    
    //create a new hotel
    Hotel create(Hotel hotel);

    //get all
    List<Hotel> getAll();

    //get a single hotel
    Hotel get(String id);

    //Delete a hotel
    void delete(String id);
}

package com.example.server.mongo.services;

import java.util.List;

import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.server.mongo.repositories.RestaurantsRepository;

@Service
public class RestaurantsServices {
    
    @Autowired
    private RestaurantsRepository restaurantsRepository;

    public List<String> listTypeOfFood(){
        return restaurantsRepository.listTypeOfFood();
    }

    public List<String> listRestaurantsByType(String foodtype){
        return restaurantsRepository.listRestaurantsByType(foodtype);
    }
}

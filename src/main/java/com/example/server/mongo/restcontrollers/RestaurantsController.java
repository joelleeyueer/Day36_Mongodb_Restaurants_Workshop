package com.example.server.mongo.restcontrollers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.server.mongo.services.RestaurantsServices;

@Controller
@RequestMapping("/")
public class RestaurantsController {

    @Autowired
    private RestaurantsServices restaurantsServices;

    @GetMapping
    public String getTypeOfFood(Model model){
        List<String> incomingTypeOfFood = restaurantsServices.listTypeOfFood();
        model.addAttribute("typeoffood", incomingTypeOfFood);

        return "view1";

    }

    @GetMapping("{foodtype}/restaurants")
    public String getRestaurantList(@PathVariable String foodtype, Model model){
        List<String> incomingRestaurants = restaurantsServices.listRestaurantsByType(foodtype);
        model.addAttribute("restaurants", incomingRestaurants);

        return "view2";

    }
    
}

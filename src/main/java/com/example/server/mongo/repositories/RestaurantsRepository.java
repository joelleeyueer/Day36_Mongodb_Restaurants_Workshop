package com.example.server.mongo.repositories;


import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;


@Repository
public class RestaurantsRepository{

    
    public static final String CRESTAURANTS = "restaurants";


    @Autowired
    private MongoTemplate mongoTemplate;

    //Write the native query

    //db.restaurants.distinct("type_of_food").sort()
    public List<String> listTypeOfFood(){
        Criteria criteria = Criteria.where(CRESTAURANTS);
        Query query = new Query();
        List<String> cuisines = mongoTemplate.findDistinct(query, "type_of_food", CRESTAURANTS, String.class);
        Collections.sort(cuisines);
        cuisines.remove(0);
        return cuisines;
    }
    //db.restaurants.distinct("name", { type_of_food: "African" })
    public List<String> listRestaurantsByType(String foodtype){
        Criteria criteria = Criteria.where("type_of_food").is(foodtype);
        Query query = new Query(criteria);

        return mongoTemplate.findDistinct(query, "name", CRESTAURANTS, String.class);

    }
    
    // db.tvshows.find( { 
    //     $and:[
    //         {"rating.average": {$gte:6.5} },
    //         {runtime: { $lte:30} }
    //         ]
    //     })
    


    
    
}

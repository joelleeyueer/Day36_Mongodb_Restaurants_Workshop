package com.example.server.mongo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.server.mongo.repositories.RestaurantsRepository;

@SpringBootApplication
public class Application implements CommandLineRunner {

	@Autowired
	private RestaurantsRepository restaurantsRepository;

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Override
    public void run(String... args) throws Exception {
        // // TODO Auto-generated method stub
		// List<Document> results = showsRepository.findTvShowByName("Game of Thrones");
		// List<Document> results2 = showsRepository.findShowtimeLessThan(30);
		List<String> result3 = restaurantsRepository.listTypeOfFood();
		List<String> result4 = restaurantsRepository.listRestaurantsByType("African");

		// System.out.println("in run");
		// for (String d: result3){
		// 	System.out.println(d);
		// }
		for (String d: result4){
			System.out.println(d);
		}
        // throw new UnsupportedOperationException("Unimplemented method 'run'");
    }

}

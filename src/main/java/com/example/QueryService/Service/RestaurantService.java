package com.example.QueryService.Service;

import com.example.QueryService.Entity.Restaurant;
import com.example.QueryService.Repository.RestaurantRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class RestaurantService {

    private final RestaurantRepository restaurantRepository;

    public RestaurantService(RestaurantRepository restaurantRepository) {
        this.restaurantRepository = restaurantRepository;
    }

    public Map<String, Object> getAllRestaurants() {
        List<Restaurant> restaurants = restaurantRepository.findAll();

        return Map.of(
                "status",HttpStatus.FOUND.value(),
                "success","Restaurants retrieved successfully",
                "data",restaurants
        );
    }

    public Map<String, Object> getRestaurantById(Long restaurantId) {

        Restaurant restaurant = restaurantRepository.findById(restaurantId)
                .orElseThrow(() -> new RuntimeException("Restaurant not found"));
        return Map.of(
                "status",HttpStatus.FOUND.value(),
                "success","Restaurants found By Id retrieved successfully",
                "data",restaurant
        );
    }


    public Map<String, Object> getRestaurantsByStatus(Restaurant.Status status) {

        List<Restaurant> restaurants = restaurantRepository.findByStatus(status);

        return Map.of(
                "status",HttpStatus.FOUND.value(),
                "success","Restaurants found By status retrieved successfully",
                "data",restaurants
        );
    }


}


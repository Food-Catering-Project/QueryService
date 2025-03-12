package com.example.QueryService.Controller;

import com.example.QueryService.Entity.Restaurant;
import com.example.QueryService.Service.RestaurantService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/restaurant")
public class RestaurantController {

    private final RestaurantService restaurantService;

    public RestaurantController(RestaurantService restaurantService) {
        this.restaurantService = restaurantService;
    }

    @GetMapping("/getAll")
    public ResponseEntity<Map<String, Object>> getAllRestaurants() {
        try {
            Map<String, Object> response = restaurantService.getAllRestaurants();
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(Map.of("message", "Unable to fetch restaurants", "error", e.getMessage()), HttpStatus.BAD_REQUEST);
        }
    }

    // Get Restaurant by ID
    @GetMapping("/getById/{restaurantId}")
    public ResponseEntity<Map<String, Object>> getRestaurantById(@PathVariable Long restaurantId) {
        try {
            Map<String, Object> response = restaurantService.getRestaurantById(restaurantId);
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(Map.of("message", "Restaurant not found", "error", e.getMessage()), HttpStatus.NOT_FOUND);
        }
    }

    // Get Restaurants by Status
    @GetMapping("/getByStatus/status")
    public ResponseEntity<Map<String, Object>> getRestaurantsByStatus(@RequestParam Restaurant.Status status) {
        try {
            Map<String, Object> response = restaurantService.getRestaurantsByStatus(status);
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(Map.of("message", "Error retrieving restaurants", "error", e.getMessage()), HttpStatus.BAD_REQUEST);
        }
    }

}

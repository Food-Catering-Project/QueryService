package com.example.QueryService.Repository;

import com.example.QueryService.Entity.Restaurant;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RestaurantRepository  extends JpaRepository<Restaurant,Long> {
    List<Restaurant> findByStatus(Restaurant.Status status);
}

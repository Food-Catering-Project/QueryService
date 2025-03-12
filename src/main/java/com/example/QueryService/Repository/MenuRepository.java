package com.example.QueryService.Repository;

import com.example.QueryService.Entity.Menu;
import com.example.QueryService.Entity.Restaurant;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MenuRepository extends JpaRepository<Menu,Long> {


    List<Menu> findByRestaurant(Restaurant restaurant);

    List<Menu> findByCategory(String category);
}

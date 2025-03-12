package com.example.QueryService.Service;

import com.example.QueryService.Entity.Menu;
import com.example.QueryService.Entity.Restaurant;
import com.example.QueryService.Repository.MenuRepository;
import com.example.QueryService.Repository.RestaurantRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class MenuService {

    private final MenuRepository menuRepository;
    private final RestaurantRepository restaurantRepository;

    public MenuService(MenuRepository menuRepository, RestaurantRepository restaurantRepository) {
        this.menuRepository = menuRepository;
        this.restaurantRepository = restaurantRepository;
    }

  
    public Map<String, Object> getAllMenuItems() {

        List<Menu> menuList = menuRepository.findAll();
        return Map.of(
                "status", HttpStatus.FOUND.value(),
                "success","Menu items retrieved successfully",
                "data",menuList
        );
    }

    // Get Menu Item by ID
    public Map<String, Object> getMenuItemById(Long menuId) {

        Menu menuItem = menuRepository.findById(menuId)
                .orElseThrow(() -> new RuntimeException("Menu item not found"));

         return Map.of(
                "status", HttpStatus.FOUND.value(),
                "success","getMenuItemById retrieved successfully",
                "data",menuItem
        );
    }

    // Get Menu Items by Restaurant ID
    public Map<String, Object> getMenuItemsByRestaurant(Long restaurantId) {

        Restaurant restaurant = restaurantRepository.findById(restaurantId)
                .orElseThrow(() -> new RuntimeException("Restaurant not found"));

        List<Menu> menuList = menuRepository.findByRestaurant(restaurant);
        return Map.of(
                "status", HttpStatus.FOUND.value(),
                "success","getMenuItemsByRestaurant retrieved successfully",
                "data",menuList
        );
    }

    // Get Menu Items by Category
    public Map<String, Object> getMenuItemsByCategory(String category) {
        Map<String, Object> response = new HashMap<>();
        List<Menu> menuList = menuRepository.findByCategory(category);
        response.put("message", "getMenuItemsByCategory retrieved successfully");
        response.put("menu", menuList);
        return response;
    }


}


package com.example.QueryService.Controller;

import com.example.QueryService.Entity.Menu;
import com.example.QueryService.Service.MenuService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/query/api/menu")
public class MenuController {

    private final MenuService menuService;

    public MenuController(MenuService menuService) {
        this.menuService = menuService;
    }

    @GetMapping("/getAllMenu")
    public ResponseEntity<Map<String, Object>> getAllMenuItems() {
        try {
            Map<String, Object> response = menuService.getAllMenuItems();
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(Map.of("message", "Unable to fetch menu items", "error", e.getMessage()), HttpStatus.BAD_REQUEST);
        }
    }

    // Get Menu Item by ID
    @GetMapping("/getMenuId/{menuId}")
    public ResponseEntity<Map<String, Object>> getMenuItemById(@PathVariable Long menuId) {
        try {
            Map<String, Object> response = menuService.getMenuItemById(menuId);
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(Map.of("message", "Menu item not found", "error", e.getMessage()), HttpStatus.NOT_FOUND);
        }
    }

    // Get Menu Items by Restaurant ID
    @GetMapping("/getMenuItemBy/{restaurantId}")
    public ResponseEntity<Map<String, Object>> getMenuItemsByRestaurant(@PathVariable Long restaurantId) {
        try {
            Map<String, Object> response = menuService.getMenuItemsByRestaurant(restaurantId);
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(Map.of("message", "Error retrieving menu items", "error", e.getMessage()), HttpStatus.BAD_REQUEST);
        }
    }

    // Get Menu Items by Category
    @GetMapping("getCategory/category")
    public ResponseEntity<Map<String, Object>> getMenuItemsByCategory(@RequestParam String category) {
        try {
            Map<String, Object> response = menuService.getMenuItemsByCategory(category);
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(Map.of("message", "Error retrieving menu items", "error", e.getMessage()), HttpStatus.BAD_REQUEST);
        }
    }

}

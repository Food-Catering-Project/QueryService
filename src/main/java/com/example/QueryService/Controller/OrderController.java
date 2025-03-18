package com.example.QueryService.Controller;

import com.example.QueryService.Entity.Order;
import com.example.QueryService.Service.OrderService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/query/api/orders")
public class OrderController {

    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }


    // Get All Orders
    @GetMapping("/getAll")
    public ResponseEntity<Map<String, Object>> getAllOrders() {
        try {
            Map<String, Object> response = orderService.getAllOrders();
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(Map.of("message", "Unable to fetch orders", "error", e.getMessage()), HttpStatus.BAD_REQUEST);
        }
    }

    // Get Order by ID
    @GetMapping("/{orderId}")
    public ResponseEntity<Map<String, Object>> getOrderById(@PathVariable Long orderId) {
        try {
            Map<String, Object> response = orderService.getOrderById(orderId);
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(Map.of("message", "Order not found", "error", e.getMessage()), HttpStatus.NOT_FOUND);
        }
    }

    // Get Orders by User ID
    @GetMapping("/user/{userId}")
    public ResponseEntity<Map<String, Object>> getOrdersByUser(@PathVariable Long userId) {
        try {
            Map<String, Object> response = orderService.getOrdersByUser(userId);
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(Map.of("message", "Error retrieving orders", "error", e.getMessage()), HttpStatus.BAD_REQUEST);
        }
    }

    // Get Orders by Restaurant ID
    @GetMapping("/restaurant/{restaurantId}")
    public ResponseEntity<Map<String, Object>> getOrdersByRestaurant(@PathVariable Long restaurantId) {
        try {
            Map<String, Object> response = orderService.getOrdersByRestaurant(restaurantId);
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(Map.of("message", "Error retrieving orders", "error", e.getMessage()), HttpStatus.BAD_REQUEST);
        }
    }

    // Get Orders by Status
    @GetMapping("/status")
    public ResponseEntity<Map<String, Object>> getOrdersByStatus(@RequestParam Order.Status status) {
        try {
            Map<String, Object> response = orderService.getOrdersByStatus(status);
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(Map.of("message", "Error retrieving orders", "error", e.getMessage()), HttpStatus.BAD_REQUEST);
        }
    }


}


package com.example.QueryService.Service;

import com.example.QueryService.Entity.Order;
import com.example.QueryService.Entity.Restaurant;
import com.example.QueryService.Entity.User;
import com.example.QueryService.Repository.OrderRepository;
import com.example.QueryService.Repository.RestaurantRepository;
import com.example.QueryService.Repository.UserRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class OrderService {

    private final OrderRepository orderRepository;
    private final UserRepository userRepository;
    private final RestaurantRepository restaurantRepository;

    public OrderService(OrderRepository orderRepository, UserRepository userRepository, RestaurantRepository restaurantRepository) {
        this.orderRepository = orderRepository;
        this.userRepository = userRepository;
        this.restaurantRepository = restaurantRepository;
    }
    // Get All Orders
    public Map<String, Object> getAllOrders() {

        List<Order> orderList = orderRepository.findAll();

        return Map.of(
                "status", HttpStatus.FOUND.value(),
                "success","Orders retrieved successfully",
                "data",orderList
        );
    }

    // Get Order by ID
    public Map<String, Object> getOrderById(Long orderId) {

        Order order = orderRepository.findById(orderId)
                .orElseThrow(() -> new RuntimeException("Order not found"));

        return Map.of(
                "status", HttpStatus.FOUND.value(),
                "success","Orders By Id retrieved successfully",
                "data",order
        );
    }

    // Get Orders by User ID
    public Map<String, Object> getOrdersByUser(Long userId) {

        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));

        List<Order> orderList = orderRepository.findByUser(user);
        return Map.of(
                "status", HttpStatus.FOUND.value(),
                "success","Orders By userId retrieved successfully",
                "data",orderList
        );
    }

    // Get Orders by Restaurant ID
    public Map<String, Object> getOrdersByRestaurant(Long restaurantId) {

        Restaurant restaurant = restaurantRepository.findById(restaurantId)
                .orElseThrow(() -> new RuntimeException("Restaurant not found"));

        List<Order> orderList = orderRepository.findByRestaurant(restaurant);

        return Map.of(
                "status", HttpStatus.FOUND.value(),
                "success","get Orders By Restaurant ID retrieved successfully",
                "data",orderList
        );
    }

    // Get Orders by Status
    public Map<String, Object> getOrdersByStatus(Order.Status status) {

        List<Order> orderList = orderRepository.findByStatus(status);
        return Map.of(
                "status", HttpStatus.FOUND.value(),
                "success","get Orders By status retrieved successfully",
                "data",orderList
        );
    }


}


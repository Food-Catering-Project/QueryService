package com.example.QueryService.Service;

import com.example.QueryService.Entity.Order;
import com.example.QueryService.Entity.Restaurant;
import com.example.QueryService.Entity.User;
import com.example.QueryService.Repository.OrderRepository;
import com.example.QueryService.Repository.RestaurantRepository;
import com.example.QueryService.Repository.UserRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.HashMap;
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


}


package com.example.QueryService.Repository;

import com.example.QueryService.Entity.Order;
import com.example.QueryService.Entity.Restaurant;
import com.example.QueryService.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderRepository  extends JpaRepository<Order,Long> {
    List<Order> findByRestaurant(Restaurant restaurant);

    List<Order> findByStatus(Order.Status status);

    List<Order> findByUser(User user);
}

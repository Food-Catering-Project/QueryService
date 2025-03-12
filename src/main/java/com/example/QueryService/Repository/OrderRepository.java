package com.example.QueryService.Repository;

import com.example.QueryService.Entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository  extends JpaRepository<Order,Long> {
}

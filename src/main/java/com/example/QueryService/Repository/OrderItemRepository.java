package com.example.QueryService.Repository;

import com.example.QueryService.Entity.Menu;
import com.example.QueryService.Entity.Order;
import com.example.QueryService.Entity.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderItemRepository extends JpaRepository<OrderItem,Long> {
    List<OrderItem> findByOrder(Order order);

    List<OrderItem> findByMenu(Menu menu);
}

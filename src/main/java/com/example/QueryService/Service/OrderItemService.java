package com.example.QueryService.Service;

import com.example.QueryService.Entity.Menu;
import com.example.QueryService.Entity.Order;
import com.example.QueryService.Entity.OrderItem;
import com.example.QueryService.Repository.MenuRepository;
import com.example.QueryService.Repository.OrderItemRepository;
import com.example.QueryService.Repository.OrderRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class OrderItemService {

    private final OrderItemRepository orderItemRepository;
    private final OrderRepository orderRepository;
    private final MenuRepository menuRepository;

    public OrderItemService(OrderItemRepository orderItemRepository, OrderRepository orderRepository, MenuRepository menuRepository) {
        this.orderItemRepository = orderItemRepository;
        this.orderRepository = orderRepository;
        this.menuRepository = menuRepository;
    }


}

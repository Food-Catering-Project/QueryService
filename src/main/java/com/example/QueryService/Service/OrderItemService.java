package com.example.QueryService.Service;

import com.example.QueryService.Entity.Menu;
import com.example.QueryService.Entity.Order;
import com.example.QueryService.Entity.OrderItem;
import com.example.QueryService.Repository.MenuRepository;
import com.example.QueryService.Repository.OrderItemRepository;
import com.example.QueryService.Repository.OrderRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
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

    // Get All Order Items
    public Map<String, Object> getAllOrderItems() {

        List<OrderItem> orderItems = orderItemRepository.findAll();

        return Map.of(
                "status", HttpStatus.FOUND.value(),
                "success","Order items retrieved successfully",
                "data",orderItems
        );
    }

    // Get Order Item by ID
    public Map<String, Object> getOrderItemById(Long orderItemId) {

        OrderItem orderItem = orderItemRepository.findById(orderItemId)
                .orElseThrow(() -> new RuntimeException("Order Item not found"));

        return Map.of(
                "status", HttpStatus.FOUND.value(),
                "success","Order Item by ID retrieved successfully",
                "data",orderItem
        );
    }

    // Get Order Items by Order ID
    public Map<String, Object> getOrderItemsByOrder(Long orderId) {

        Order order = orderRepository.findById(orderId)
                .orElseThrow(() -> new RuntimeException("Order not found"));

        List<OrderItem> orderItems = orderItemRepository.findByOrder(order);
        return Map.of(
                "status", HttpStatus.FOUND.value(),
                "success","Order Items by Order ID retrieved successfully",
                "data",orderItems
        );
    }

    // Get Order Items by Menu ID
    public Map<String, Object> getOrderItemsByMenu(Long menuId) {

        Menu menu = menuRepository.findById(menuId)
                .orElseThrow(() -> new RuntimeException("Menu Item not found"));

        List<OrderItem> orderItems = orderItemRepository.findByMenu(menu);
        return Map.of(
                "status", HttpStatus.FOUND.value(),
                "success","Order  Order Items by Menu ID retrieved successfully",
                "data",orderItems
        );
    }
}

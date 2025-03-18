package com.example.QueryService.Controller;

import com.example.QueryService.Service.OrderItemService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/query/api/orderItems")
public class OrderItemController {

    private final OrderItemService orderItemService;


    public OrderItemController(OrderItemService orderItemService) {
        this.orderItemService = orderItemService;
    }

    // Get All Order Items
    @GetMapping("/getAll")
    public ResponseEntity<Map<String, Object>> getAllOrderItems() {
        try {
            Map<String, Object> response = orderItemService.getAllOrderItems();
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(Map.of("message", "Unable to fetch order items", "error", e.getMessage()), HttpStatus.BAD_REQUEST);
        }
    }

    // Get Order Item by ID
    @GetMapping("/{orderItemId}")
    public ResponseEntity<Map<String, Object>> getOrderItemById(@PathVariable Long orderItemId) {
        try {
            Map<String, Object> response = orderItemService.getOrderItemById(orderItemId);
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(Map.of("message", "Order item not found", "error", e.getMessage()), HttpStatus.NOT_FOUND);
        }
    }

    // Get Order Items by Order ID
    @GetMapping("/order/{orderId}")
    public ResponseEntity<Map<String, Object>> getOrderItemsByOrder(@PathVariable Long orderId) {
        try {
            Map<String, Object> response = orderItemService.getOrderItemsByOrder(orderId);
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(Map.of("message", "Error retrieving order items", "error", e.getMessage()), HttpStatus.BAD_REQUEST);
        }
    }

    // Get Order Items by Menu ID
    @GetMapping("/menu/{menuId}")
    public ResponseEntity<Map<String, Object>> getOrderItemsByMenu(@PathVariable Long menuId) {
        try {
            Map<String, Object> response = orderItemService.getOrderItemsByMenu(menuId);
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(Map.of("message", "Error retrieving order items", "error", e.getMessage()), HttpStatus.BAD_REQUEST);
        }
    }
}

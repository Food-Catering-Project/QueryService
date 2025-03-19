package com.example.QueryService.Controller;

import com.example.QueryService.Entity.CateringOrder;
import com.example.QueryService.Service.CateringOrderService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("action/api/cateringorders")
public class CateringOrderController {

    private final CateringOrderService cateringOrderService;

    public CateringOrderController(CateringOrderService cateringOrderService) {
        this.cateringOrderService = cateringOrderService;
    }

    @GetMapping("/getAllCateringOrder")
    public ResponseEntity<Map<String, Object>> getAllCateringOrder() {
        try {
            Map<String, Object> orders = cateringOrderService.getAllCateringOrder();
            return new ResponseEntity<>(orders,HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(Map.of("message", "Unable to getAllCateringOrder", "error", e.getMessage()), HttpStatus.BAD_REQUEST);
        }
    }





}

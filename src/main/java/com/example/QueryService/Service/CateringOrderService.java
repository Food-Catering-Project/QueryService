package com.example.QueryService.Service;

import com.example.QueryService.Entity.CateringOrder;
import com.example.QueryService.Repository.CateringOrderRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class CateringOrderService {

    private final CateringOrderRepository cateringOrderRepository;

    public CateringOrderService(CateringOrderRepository cateringOrderRepository) {
        this.cateringOrderRepository = cateringOrderRepository;
    }


    public Map<String,Object> getAllCateringOrder() {
        List<CateringOrder> cateringOrder = cateringOrderRepository.findAll();
        return Map.of(
                "status", HttpStatus.CREATED,
                "message", "CateringOrder added successfully ",
                "data", cateringOrder
        );
    }


}
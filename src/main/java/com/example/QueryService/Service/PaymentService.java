package com.example.QueryService.Service;

import com.example.QueryService.Entity.Order;
import com.example.QueryService.Entity.Payment;
import com.example.QueryService.Entity.User;
import com.example.QueryService.Repository.OrderRepository;
import com.example.QueryService.Repository.PaymentRepository;
import com.example.QueryService.Repository.UserRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Map;

@Service
public class PaymentService {

    private final PaymentRepository paymentRepository;
    private final UserRepository userRepository;
    private final OrderRepository orderRepository;

    public PaymentService(PaymentRepository paymentRepository, UserRepository userRepository, OrderRepository orderRepository) {
        this.paymentRepository = paymentRepository;
        this.userRepository = userRepository;
        this.orderRepository = orderRepository;
    }

}

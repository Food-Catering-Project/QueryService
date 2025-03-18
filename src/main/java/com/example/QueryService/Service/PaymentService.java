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
import java.util.HashMap;
import java.util.List;
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

    public Map<String, Object> getAllPayments() {

        List<Payment> payments = paymentRepository.findAll();

        return Map.of(
                "status", HttpStatus.FOUND.value(),
                "success"," Payments retrieved successfully",
                "data",payments
        );
    }

    // Get Payment by ID
    public Map<String, Object> getPaymentById(Long paymentId) {

        Payment payment = paymentRepository.findById(paymentId)
                .orElseThrow(() -> new RuntimeException("Payment not found"));

        return Map.of(
                "status", HttpStatus.FOUND.value(),
                "success"," Payment by ID retrieved successfully",
                "data",payment
        );
    }

    // Get Payments by Order ID
    public Map<String, Object> getPaymentsByOrder(Long orderId) {

        Order order = orderRepository.findById(orderId)
                .orElseThrow(() -> new RuntimeException("Order not found"));

        List<Payment> payments = paymentRepository.findByOrder(order);
        return Map.of(
                "status", HttpStatus.FOUND.value(),
                "success"," Payments by Order ID retrieved successfully",
                "data",payments
        );
    }

    // Get Payments by User ID
    public Map<String, Object> getPaymentsByUser(Long userId) {

        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));

        List<Payment> payments = paymentRepository.findByUser(user);


        return Map.of(
                "status", HttpStatus.FOUND.value(),
                "success"," Payments by User ID retrieved successfully",
                "data",payments
        );
    }
}

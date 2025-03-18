package com.example.QueryService.Controller;

import com.example.QueryService.Entity.Payment;
import com.example.QueryService.Service.PaymentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/query/api/payment")
public class PaymentController {

    private final PaymentService paymentService;

    public PaymentController(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    @GetMapping("/getAll")
    public ResponseEntity<Map<String, Object>> getAllPayments() {
        try {
            Map<String, Object> response = paymentService.getAllPayments();
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(Map.of("message", "Unable to fetch payments", "error", e.getMessage()), HttpStatus.BAD_REQUEST);
        }
    }

    // Get Payment by ID
    @GetMapping("/{paymentId}")
    public ResponseEntity<Map<String, Object>> getPaymentById(@PathVariable Long paymentId) {
        try {
            Map<String, Object> response = paymentService.getPaymentById(paymentId);
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(Map.of("message", "Payment not found", "error", e.getMessage()), HttpStatus.NOT_FOUND);
        }
    }

    // Get Payments by Order ID
    @GetMapping("/order/{orderId}")
    public ResponseEntity<Map<String, Object>> getPaymentsByOrder(@PathVariable Long orderId) {
        try {
            Map<String, Object> response = paymentService.getPaymentsByOrder(orderId);
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(Map.of("message", "Error retrieving payments", "error", e.getMessage()), HttpStatus.BAD_REQUEST);
        }
    }

    // Get Payments by User ID
    @GetMapping("/user/{userId}")
    public ResponseEntity<Map<String, Object>> getPaymentsByUser(@PathVariable Long userId) {
        try {
            Map<String, Object> response = paymentService.getPaymentsByUser(userId);
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(Map.of("message", "Error retrieving payments", "error", e.getMessage()), HttpStatus.BAD_REQUEST);
        }
    }
}

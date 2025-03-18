package com.example.QueryService.Repository;

import com.example.QueryService.Entity.Order;
import com.example.QueryService.Entity.Payment;
import com.example.QueryService.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PaymentRepository extends JpaRepository<Payment,Long> {
    List<Payment> findByOrder(Order order);

    List<Payment> findByUser(User user);
}

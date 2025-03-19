package com.example.QueryService.Repository;


import com.example.QueryService.Entity.CateringOrder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CateringOrderRepository extends JpaRepository<CateringOrder, Long> {
}

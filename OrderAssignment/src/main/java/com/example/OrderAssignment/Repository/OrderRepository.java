package com.example.OrderAssignment.Repository;

import com.example.OrderAssignment.Model.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
}


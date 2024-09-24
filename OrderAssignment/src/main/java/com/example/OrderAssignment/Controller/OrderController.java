package com.example.OrderAssignment.Controller;

import com.example.OrderAssignment.Model.Order;
import com.example.OrderAssignment.Service.KafkaProducerService;
import com.example.OrderAssignment.Service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private OrderService orderService;
    @Autowired
    private KafkaProducerService kafkaProducerService;

    @GetMapping("/get")
    public List<Order> getAllOrders() {
        return orderService.getAllOrders();
    }

    @GetMapping("/getProducts/{id}")
    public ResponseEntity<?> getOrderById(@PathVariable Long id) {

        return ResponseEntity.ok(orderService.getProduct(id));
    }

    @PostMapping("/add")
    public ResponseEntity<Order> createOrder(@RequestBody Order order) {
        kafkaProducerService.publishMsg("Requesting for product for this order");
        return new ResponseEntity<>(orderService.createOrder(order), HttpStatus.CREATED);
    }

    @PutMapping("update/{id}")
    public ResponseEntity<Order> updateOrder(@PathVariable Long id, @RequestBody Order orderDetails) {
        return ResponseEntity.ok(orderService.updateOrder(id, orderDetails));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteOrder(@PathVariable Long id) {
        orderService.deleteOrder(id);
        return ResponseEntity.noContent().build();
    }
}


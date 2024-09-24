package com.example.OrderAssignment.Service;

import com.example.OrderAssignment.Model.Order;
import com.example.OrderAssignment.Repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class OrderService {
    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    private static final String TOPIC = "order_topic";

    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }

    public Object getProduct(Long id) {
        Order order=orderRepository.findById(id).orElseThrow(() -> new RuntimeException("Order not found"));
        System.out.println(order);
        ResponseEntity<?> response = restTemplate.getForEntity("http://localhost:8086/product/getById/" + order.getProductId(), Object.class);

        // Return the body of the response
        return response.getBody();

    }

    public Order createOrder(Order order) {
        Order savedOrder = orderRepository.save(order);

        // Send order details to Kafka topic
        String message = "Order Created: " + savedOrder.toString();
        sendOrderMessage(message);

        return savedOrder;
    }
    private void sendOrderMessage(String message) {
        System.out.println("Sending message to Kafka: " + message);
        kafkaTemplate.send(TOPIC, message);
    }

    public Order getOrderById(Long id) {
        return orderRepository.findById(id).orElseThrow(() -> new RuntimeException("Order not found"));
    }

    public Order updateOrder(Long id, Order orderDetails) {
        Order order = getOrderById(id);
        order.setOrderNumber(orderDetails.getOrderNumber());
        order.setProductId(orderDetails.getProductId());
        order.setQuantity(orderDetails.getQuantity());
        return orderRepository.save(order);
    }

    public void deleteOrder(Long id) {
        orderRepository.deleteById(id);
    }
}


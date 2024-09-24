package com.example.MicroServicesAssignment.Service;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumerService {

    @KafkaListener(topics = "order-topic", groupId = "group_id")
    public void handleOrderMessage(String message) {
        // Handle incoming order message from Kafka
        System.out.println("Order is Received : " + message);
        // You can add custom logic here to update product details or inventory based on the order
    }
}

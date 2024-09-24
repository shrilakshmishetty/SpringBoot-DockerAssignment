package com.example.OrderAssignment.Service;

import com.example.OrderAssignment.Config.KafkaProducerConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class KafkaProducerService {

    @Autowired
    private KafkaTemplate<String,String> kafkaTemplate;
    public boolean publishMsg(String msg){
        kafkaTemplate.send(KafkaProducerConfig.topic_Name,msg);
        return true;

    }
}

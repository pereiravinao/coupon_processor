package com.pereiravinao.coupon_processor.service.impl;

import com.pereiravinao.coupon_processor.service.RabbitMQService;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

@Service
public class RabbitMQServiceImpl implements RabbitMQService {

    private final RabbitTemplate rabbitTemplate;

    public RabbitMQServiceImpl(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    @Override
    public void publishMessage(String queueName, Object message) {
        rabbitTemplate.convertAndSend(queueName, message);
        System.out.println("Message sent to queue " + queueName + ": " + message);
    }

    @Override
    public void processMessage(String queueName, Object message) {
        System.out.println("Processing message from queue " + queueName + ": " + message);
    }
}

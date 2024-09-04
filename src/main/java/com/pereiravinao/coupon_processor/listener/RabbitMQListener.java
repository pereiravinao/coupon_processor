package com.pereiravinao.coupon_processor.listener;

import com.pereiravinao.coupon_processor.service.RabbitMQService;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class RabbitMQListener {

    private final RabbitMQService rabbitMQService;

    public RabbitMQListener(RabbitMQService rabbitMQService) {
        this.rabbitMQService = rabbitMQService;
    }

    @RabbitListener(queues = "coupon.queue")
    public void handleMessage(Object message) {
        rabbitMQService.processMessage("coupon.queue", message);
    }
}

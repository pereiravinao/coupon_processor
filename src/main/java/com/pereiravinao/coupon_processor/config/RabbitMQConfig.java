package com.pereiravinao.coupon_processor.config;


import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQConfig {

    public static final String QUEUE_NAME = "coupon.queue";

    @Bean
    public Queue couponQueue() {
        return new Queue(QUEUE_NAME, false);
    }
}
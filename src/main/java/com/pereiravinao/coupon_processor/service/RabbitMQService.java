package com.pereiravinao.coupon_processor.service;

public interface RabbitMQService {

    void publishMessage(String queueName, Object message);

}

package com.kimo.rabbitmq.simpl;


import org.junit.jupiter.api.Test;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class DemoProducerTest {
    @Autowired
    private RabbitTemplate rabbitTemplate;

    /**
     * 简单模式
     *
     */
    @Test
    public void testSendSimpleMessage(){
        rabbitTemplate.convertAndSend("simple_exchange", "simple","hello simple");
    }
}

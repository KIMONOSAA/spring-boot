package com.kimo.rabbitmq.simpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class DemoSimpleListener {

    @RabbitHandler
    @RabbitListener(queues = "simple_queue")
    public void listen(String message){
        log.info("接收到消息：----------------------------------------------"  + message);
    }
}

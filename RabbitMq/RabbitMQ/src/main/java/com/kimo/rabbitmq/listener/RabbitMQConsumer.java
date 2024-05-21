package com.kimo.rabbitmq.listener;



import com.alibaba.fastjson.JSONObject;
import com.kimo.rabbitmq.dto.RabbitMessageDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.io.IOException;


import static com.kimo.rabbitmq.constant.RabbitMQConstant.*;

@Slf4j
@Component
public class RabbitMQConsumer {



    @RabbitHandler
    @RabbitListener(queues = DIRECT_QUEUE)
    public void receiveDirectQueue(Message message) throws IOException {
        String msg = new String(message.getBody());
        log.info("消费者接收到消息: {}", msg);
    }


    @RabbitHandler
    @RabbitListener(queuesToDeclare  = @Queue(FANOUT_QUEUE_A))
    public void processFanoutA(RabbitMessageDTO message){
        log.info("消费者 a 消息 {}", JSONObject.toJSONString(message));
    }

    @RabbitHandler
    @RabbitListener(queuesToDeclare  = @Queue(FANOUT_QUEUE_B))
    public void processFanoutB(RabbitMessageDTO message){
        log.info("消费者 b 消息 {}", JSONObject.toJSONString(message));
    }

    @RabbitHandler
    @RabbitListener(queuesToDeclare  = @Queue(FANOUT_QUEUE_C))
    public void processFanoutC(RabbitMessageDTO message){
        log.info("消费者 c 消息 {}", JSONObject.toJSONString(message));
    }

    @RabbitHandler
    @RabbitListener(queuesToDeclare  = @Queue(TOPIC_QUEUE_A))
    public void processTopicA(RabbitMessageDTO message){
        log.info("消费者 topic.a 消息 {}", JSONObject.toJSONString(message));
    }

    @RabbitHandler
    @RabbitListener(queuesToDeclare  = @Queue(TOPIC_QUEUE_B))
    public void processTopicB(RabbitMessageDTO message){
        log.info("消费者 topic.b 消息 {}", JSONObject.toJSONString(message));
    }


}

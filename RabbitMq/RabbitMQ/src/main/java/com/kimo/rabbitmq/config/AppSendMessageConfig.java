package com.kimo.rabbitmq.config;

import com.kimo.rabbitmq.dto.RabbitMessageDTO;
import com.kimo.rabbitmq.utils.OrderNoutils;
import jakarta.annotation.PostConstruct;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.ReturnedMessage;
import org.springframework.amqp.rabbit.connection.CorrelationData;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class AppSendMessageConfig implements RabbitTemplate.ConfirmCallback,RabbitTemplate.ReturnsCallback{
    @Autowired
    private RabbitTemplate template;

    @PostConstruct
    public void init() {
        template.setConfirmCallback(this);
        template.setReturnsCallback(this);
    }

    public void sendMsg(String exchange, String key, RabbitMessageDTO msg) {
        CorrelationData data = new CorrelationData();
        data.setId(OrderNoutils.idStr());
        template.convertAndSend(exchange, key, msg, data);
    }

    @Override
    public void confirm(CorrelationData data, boolean ack, String cause) {
        if(ack){
            log.info("消息{}已发出,成功到达交换机,消息:{},ack:{}",data,data,ack);
        }else{
            log.error("消息{}已发出,未到达交换机,消息:{},ack:{},cause:{}",data.getId(),data,ack,cause);
        }
    }

    @Override
    public void returnedMessage(ReturnedMessage returnedMessage) {
        Message message = returnedMessage.getMessage();
        int replyCode = returnedMessage.getReplyCode();
        String replyText = returnedMessage.getReplyText();
        String exchange = returnedMessage.getExchange();
        String routingKey = returnedMessage.getRoutingKey();
        log.info("消息 {} 未被路由到队列 {} replyText {} exchange {} key {}" , message , replyCode , replyText , exchange , routingKey);
    }


}
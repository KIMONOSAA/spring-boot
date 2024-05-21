package com.kimo.rabbitmq.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.kimo.rabbitmq.config.AppSendMessageConfig;
import com.kimo.rabbitmq.dto.RabbitMessageDTO;
import com.kimo.rabbitmq.service.RabbitMQService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * RabbitMQServiceImpl
 * @author Kimo

 */
@Service
@Slf4j
public class RabbitMQServiceImpl implements RabbitMQService {



    @Autowired
    private RabbitTemplate template;

    @Override
    public void sendMessage(String directExchange, String directRoutingKey, RabbitMessageDTO messageDTO) {
        log.info("Send message to RabbitMQ: {}", messageDTO);
        template.convertAndSend(directExchange, directRoutingKey, messageDTO);
    }
}

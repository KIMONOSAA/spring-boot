package com.kimo.rabbitmq.service;

import com.kimo.rabbitmq.dto.RabbitMessageDTO;
import org.springframework.stereotype.Service;

/**
 * RabbitMQService
 * @author Kimo
 */

public interface RabbitMQService {

    void sendMessage(String directExchange, String directRoutingKey, RabbitMessageDTO messageDTO);
}

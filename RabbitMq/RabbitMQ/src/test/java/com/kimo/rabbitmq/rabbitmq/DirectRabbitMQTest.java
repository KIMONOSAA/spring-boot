package com.kimo.rabbitmq.rabbitmq;

import com.kimo.rabbitmq.dto.RabbitMessageDTO;
import com.kimo.rabbitmq.service.RabbitMQService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import static com.kimo.rabbitmq.constant.RabbitMQConstant.*;

/**
 * DirectRabbitMQTest
 * @author Kimo

 */

@SpringBootTest
public class DirectRabbitMQTest {

    @Autowired
    private RabbitMQService rabbitMQService;

    @Test
    public void testSendDirectMessage() {
        RabbitMessageDTO messageDTO = new RabbitMessageDTO();
        messageDTO.setMessage("direct message");
        messageDTO.setCode("200");
        messageDTO.setTimestamp(DateTimeFormatter.ofPattern("yyyy-MM-dd").format(LocalDateTime.now()));
        String directExchange = DIRECT_EXCHANGE;
        String directRoutingKey = DIRECT_ROUTING_KEY;
          rabbitMQService.sendMessage(directExchange, directRoutingKey, messageDTO);

    }

    @Test
    public void testSendFanoutMessage() {
        RabbitMessageDTO messageDTO = new RabbitMessageDTO();
        messageDTO.setMessage("fanout message");
        messageDTO.setCode("200");
        messageDTO.setTimestamp(DateTimeFormatter.ofPattern("yyyy-MM-dd").format(LocalDateTime.now()));
        String directExchange = FANOUT_EXCHANGE;
        rabbitMQService.sendMessage(directExchange, "", messageDTO);

    }
}

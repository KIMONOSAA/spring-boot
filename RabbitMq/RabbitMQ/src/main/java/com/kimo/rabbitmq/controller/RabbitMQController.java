package com.kimo.rabbitmq.controller;


import cn.hutool.core.util.StrUtil;
import com.kimo.rabbitmq.dto.RabbitMessageDTO;
import com.kimo.rabbitmq.service.RabbitMQService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import static com.kimo.rabbitmq.constant.RabbitMQConstant.*;


@RestController
@RequestMapping("/rabbitmq")
public class RabbitMQController {

    @Autowired
    private RabbitMQService rabbitMQService;

    @PostMapping("/direct/send")
    public String sendDirectMessage(@RequestParam String type){
        RabbitMessageDTO messageDTO = new RabbitMessageDTO();
        messageDTO.setCode("200");
        messageDTO.setTimestamp(DateTimeFormatter.ofPattern("yyyy-MM-dd").format(LocalDateTime.now()));
        if(StrUtil.equals("direct",type)){
            messageDTO.setMessage("direct message");
            rabbitMQService.sendMessage(DIRECT_EXCHANGE,DIRECT_ROUTING_KEY,messageDTO);
            return "send direct message success";
        }
        if(StrUtil.equals("fanout",type)){
            messageDTO.setMessage("fanout message");
            rabbitMQService.sendMessage(FANOUT_EXCHANGE,"",messageDTO);
            return "send fanout message success";
        }
        if(StrUtil.equals("topic",type)){
            messageDTO.setMessage("topic message");
            rabbitMQService.sendMessage(TOPIC_EXCHANGE,TOPIC_ROUTING_KEY_A,messageDTO);
            return "send topic message success";
        }
        return "send direct message fail";
    }


}

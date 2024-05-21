package com.kimo.rabbitmq.simpl;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/simpl/rabbitmq")
public class DemoSimplController {

    @PostMapping("/send")
    public String send(@RequestBody String msg) {

        return "Message sent!";
    }

}

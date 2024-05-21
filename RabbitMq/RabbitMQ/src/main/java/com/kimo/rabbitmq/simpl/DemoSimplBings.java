package com.kimo.rabbitmq.simpl;


import lombok.Getter;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
@Getter
public class DemoSimplBings {

    @Bean
    public Queue simpleQueue(){
        return new Queue("simple_queue",true,false,false);
    }

    @Bean
    public DirectExchange simpleExchange(){
        return new DirectExchange("simple_exchange",true,false);
    }

    @Bean
    public Binding simpleBinding(){
        return BindingBuilder.bind(simpleQueue()).to(simpleExchange()).with("simple");
    }
}

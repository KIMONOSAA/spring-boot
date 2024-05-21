package com.kimo.rabbitmq.config;

import org.springframework.amqp.core.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import static com.kimo.rabbitmq.constant.RabbitMQConstant.*;

/**
 * RabbitMQ 配置类
 * @Author: kimo
 */
@Configuration
public class RabbitMQConfig {

    /**
     * Direct 交换机
     */
    @Bean
    public DirectExchange directExchange(){
        return new DirectExchange(DIRECT_EXCHANGE,true,false);
    }

    @Bean
    public Queue directQueue(){
        return new Queue(DIRECT_QUEUE,true,false,false);
    }

    @Bean
    public Binding directBinding(){
        return BindingBuilder.bind(directQueue()).to(directExchange()).with(DIRECT_ROUTING_KEY);
    }


    /**
     * Fanout 交换机
     */
    @Bean
    public FanoutExchange fanoutExchange(){
        return new FanoutExchange(FANOUT_EXCHANGE,true,false);
    }

    @Bean
    public Queue fanoutQueueA(){
        return new Queue(FANOUT_QUEUE_A,true,false,false);
    }

    @Bean
    public Queue fanoutQueueB(){
        return new Queue(FANOUT_QUEUE_B,true,false,false);
    }

    @Bean
    public Queue fanoutQueueC(){
        return new Queue(FANOUT_QUEUE_C,true,false,false);
    }

    @Bean
    public Binding fanoutBindingA(){
        return BindingBuilder.bind(fanoutQueueA()).to(fanoutExchange());
    }

    @Bean
    public Binding fanoutBindingB(){
        return BindingBuilder.bind(fanoutQueueB()).to(fanoutExchange());
    }

    @Bean
    public Binding fanoutBindingC(){
        return BindingBuilder.bind(fanoutQueueC()).to(fanoutExchange());
    }


    /**
     * Topic 交换机
     */
    @Bean
    public TopicExchange topicExchange(){
        return new TopicExchange(TOPIC_EXCHANGE,true,false);
    }

    @Bean
    public Queue topicQueueA(){
        return new Queue(TOPIC_QUEUE_A,true,false,false);
    }

    @Bean
    public Queue topicQueueB(){
        return new Queue(TOPIC_QUEUE_B,true,false,false);
    }


    @Bean
    public Binding topicBindingAll(){
        return BindingBuilder.bind(topicQueueA()).to(topicExchange()).with(TOPIC_ROUTING_KEY_ALL);
    }



}

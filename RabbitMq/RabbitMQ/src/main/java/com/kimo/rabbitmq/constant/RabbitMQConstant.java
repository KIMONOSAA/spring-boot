package com.kimo.rabbitmq.constant;

import org.springframework.stereotype.Component;

/**
 * RabbitMQ 消息常量
 * @author kimo
 */
public class RabbitMQConstant {

    /**
     * direct 交换机
     */
    public static final String DIRECT_EXCHANGE = "direct_exchange";
    public static final String DIRECT_QUEUE = "direct_queue";
    public static final String DIRECT_ROUTING_KEY = "direct";

    /**
     * fanout 交换机
     */
    public static final String FANOUT_EXCHANGE = "fanout_exchange";
    public static final String FANOUT_QUEUE_A = "fanout_queue_a";
    public static final String FANOUT_QUEUE_B = "fanout_queue_b";
    public static final String FANOUT_QUEUE_C = "fanout_queue_c";

    /**
     * topic 交换机
     */
    public static final String TOPIC_EXCHANGE = "topic_exchange";
    public static final String TOPIC_QUEUE_A = "topic_queue_a";
    public static final String TOPIC_QUEUE_B = "topic_queue_b";

    public static final String TOPIC_ROUTING_KEY_A = "topic.queue.a";
    public static final String TOPIC_ROUTING_KEY_B = "topic.queue.b";
    public static final String TOPIC_ROUTING_KEY_ALL = "topic.queue.#";
}

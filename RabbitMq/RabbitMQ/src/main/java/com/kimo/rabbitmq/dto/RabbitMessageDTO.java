package com.kimo.rabbitmq.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.io.Serial;
import java.io.Serializable;


/**
 * RabbitMessageDTO
 * @author Kimo
 */

@Data
public class RabbitMessageDTO implements Serializable {


    @Serial
    private static final long serialVersionUID = 5346814929851991801L;
    private String code;

    private String message;

    private String timestamp;


}

package com.kafka.consumer.DTO;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class TesteDTO {
    private String order_id;
    private String nome;
    private Integer idade;
}

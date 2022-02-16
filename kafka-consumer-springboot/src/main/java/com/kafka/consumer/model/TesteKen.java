package com.kafka.consumer.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@NoArgsConstructor
@Table(name = "teste_ken")
public class TesteKen {

    @Id
    private String order_id;
    private String nome;
    private Integer idade;

    @Column(name = "hora_criacao")
    private Date dataCriacao;

}

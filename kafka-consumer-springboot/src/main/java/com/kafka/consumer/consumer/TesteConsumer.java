package com.kafka.consumer.consumer;

import com.kafka.consumer.DTO.TesteDTO;
import com.kafka.consumer.service.TesteService;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class TesteConsumer {

    private final TesteService service;

    private static final Logger log = LoggerFactory.getLogger(TesteConsumer.class);

    @Value(value = "${topic.name}")
    private String topic;

    @Value(value = "${spring.kafka.group-id}")
    private String groupId;

    public TesteConsumer(TesteService service) {this.service = service;}

    @KafkaListener(topics = "${topic.name}", groupId = "${spring.kafka.group-id}", containerFactory = "testeKafkaListenerContainerFactory")
    public void listenTopic(ConsumerRecord<String, TesteDTO> record){
        log.info("Received Message " + record.partition());
        log.info("Received Message " + record.value());

        service.salvar(record.value(), new Date(record.timestamp()));
    }
}

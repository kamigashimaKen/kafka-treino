package com.kafka.consumer.service;

import com.kafka.consumer.DTO.TesteDTO;
import com.kafka.consumer.model.TesteKen;
import com.kafka.consumer.repository.TesteRepository;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class TesteService {

    private final TesteRepository repository;
    private TesteKen model = new TesteKen();

    public TesteService(TesteRepository repository) {
        this.repository = repository;
    }

    public void salvar(TesteDTO dto, Date dataCriacao) {

        if (null != dto.getOrder_id()) {
            model.setOrder_id(dto.getOrder_id());
        }
        if (null != dto.getNome()) {
            model.setNome(dto.getNome());
        }
        if (null != dto.getIdade()) {
            model.setIdade(dto.getIdade());
        }

        model.setDataCriacao(dataCriacao);

        model = repository.save(model);
    }

}

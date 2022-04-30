package com.uenderley.challenge.facade;

import com.uenderley.challenge.model.dto.PessoaDTO;
import com.uenderley.challenge.model.mapper.PessoaMapper;
import com.uenderley.challenge.service.PessoaService;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Component
public class FacadeV1 {

    @Autowired
    PessoaService pessoaService;

    private PessoaMapper mapper = Mappers.getMapper(PessoaMapper.class);

    public Flux<PessoaDTO> findAll() {
        return pessoaService.findAll()
                .map(pessoaAux -> mapper.mapper(pessoaAux));
    }

    public Mono<PessoaDTO> findById(Integer id) {
        return pessoaService.findById(id)
                .map(mapper::mapper);
    }

    public Mono<PessoaDTO> save(PessoaDTO pessoaDTO) {
        return pessoaService.save(mapper.mapper(pessoaDTO))
                .map(mapper::mapper);
    }
}
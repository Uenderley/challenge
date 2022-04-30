package com.uenderley.challenge.facade;

import com.uenderley.challenge.model.dto.request.PessoaDTO;
import com.uenderley.challenge.model.dto.response.PessoaResponseDTO;
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

    public Flux<PessoaResponseDTO> findAll() {
        return pessoaService.findAll()
                .map(pessoaAux -> mapper.mapper(pessoaAux));
    }

    public Mono<PessoaResponseDTO> findById(Integer id) {
        return pessoaService.findById(id)
                .map(mapper::mapper);
    }

    public Mono<PessoaResponseDTO> save(PessoaDTO pessoaDTO) {
        return pessoaService.save(mapper.mapper(pessoaDTO))
                .map(mapper::mapper);
    }

    public Mono<Void> update(PessoaDTO pessoaDTO) {
        return pessoaService.update(mapper.mapper(pessoaDTO));
    }

    public Mono<Void> updateStatus(PessoaDTO pessoaDTO) {
        return pessoaService.updateStatus(mapper.mapper(pessoaDTO));
    }

    public Mono<Void> deleteById(Integer idPessoa) {
        return pessoaService.deleteById(idPessoa);
    }
}

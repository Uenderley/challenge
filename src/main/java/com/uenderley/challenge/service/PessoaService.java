package com.uenderley.challenge.service;

import com.uenderley.challenge.model.Pessoa;
import com.uenderley.challenge.repository.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class PessoaService {
    @Autowired
    PessoaRepository pessoaRepository;

    public Flux<Pessoa> findAll() {
        return pessoaRepository.findAll();
    }

    public Mono<Pessoa> findById(Integer id) {
        return pessoaRepository.findById(id);
    }

    public Mono<Pessoa> save(Pessoa pessoa) {
        return pessoaRepository.save(pessoa);
    }

    public Mono<Void> update(Pessoa pessoa) {
        return pessoaRepository.findById(pessoa.getId())
                .map(pessoaAux -> pessoaAux)
                .flatMap(pessoaRepository::save)
                .thenEmpty(Mono.empty());
    }
}

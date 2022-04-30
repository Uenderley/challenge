package com.uenderley.challenge.repository;

import com.uenderley.challenge.model.Pessoa;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

public interface PessoaRepository extends ReactiveCrudRepository<Pessoa, Integer> {
}

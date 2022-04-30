package com.uenderley.challenge.service;

import com.uenderley.challenge.repository.PessoaRepository;
import com.uenderley.challenge.stub.PessoaStub;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

@ExtendWith({MockitoExtension.class})
public class PessoaServiceTest {
    @Mock
    PessoaRepository pessoaRepository;

    @InjectMocks
    PessoaService pessoaService;

    @Test
    void deveRetornarListaPessoa() {
        final var pessoa = PessoaStub.build();
        Mockito.when(pessoaRepository.findAll()).thenReturn(Flux.just(pessoa));

        StepVerifier.create(pessoaService.findAll())
                .assertNext(response -> Assertions.assertEquals(pessoa, response))
                .verifyComplete();
    }

    @Test
    void deveRetornarPessoa() {
        final var pessoa = PessoaStub.build();
        Mockito.when(pessoaRepository.findById(pessoa.getId())).thenReturn(Mono.just(pessoa));

        StepVerifier.create(pessoaService.findById(pessoa.getId()))
                .assertNext(response -> Assertions.assertEquals(pessoa, response))
                .verifyComplete();
    }
}

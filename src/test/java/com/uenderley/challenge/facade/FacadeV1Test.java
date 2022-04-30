package com.uenderley.challenge.facade;

import com.uenderley.challenge.service.PessoaService;
import com.uenderley.challenge.stub.PessoaDTOStub;
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
public class FacadeV1Test {

    @Mock
    PessoaService pessoaService;

    @InjectMocks
    FacadeV1 facadeV1;

    @Test
    void deveRetornarListaPessoa() {
        final var pessoa = PessoaStub.build();
        final var expected = PessoaDTOStub.build();
        Mockito.when(pessoaService.findAll()).thenReturn(Flux.just(pessoa));

        StepVerifier.create(facadeV1.findAll())
                .assertNext(response -> Assertions.assertEquals(expected, response))
                .verifyComplete();
    }

    @Test
    void deveRetornarPessoa() {
        final var pessoa = PessoaStub.build();
        final var expected = PessoaDTOStub.build();
        Mockito.when(pessoaService.findById(pessoa.getId())).thenReturn(Mono.just(pessoa));

        StepVerifier.create(facadeV1.findById(pessoa.getId()))
                .assertNext(response -> Assertions.assertEquals(expected, response))
                .verifyComplete();
    }
}

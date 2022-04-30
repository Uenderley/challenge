package com.uenderley.challenge.controller;

import com.uenderley.challenge.facade.FacadeV1;
import com.uenderley.challenge.stub.PessoaDTOStub;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.WebFluxTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Import;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.reactive.server.WebTestClient;
import reactor.core.publisher.Flux;

import static org.mockito.Mockito.when;

@ExtendWith(SpringExtension.class)
@WebFluxTest(controllers = ChallengeControllerV1.class)
@Import(FacadeV1.class)
public class ChallengeControllerV1Test {

    @MockBean
    FacadeV1 facadeV1;

    @Autowired
    WebTestClient webTestClient;
    @Autowired
    ApplicationContext applicationContext;

    @BeforeEach
    public void setup() {
        this.webTestClient = WebTestClient.bindToApplicationContext(applicationContext)
                .configureClient()
                .build();
    }

    @Test
    void shouldReturn2xxStatus() {
        final var pessoa = PessoaDTOStub.build();
        when(facadeV1.findAll())
                .thenReturn(Flux.just(pessoa));

        webTestClient
                .get()
                .uri("/v1/")
                .header("User-Agent", "PostmanRuntime/7.26.10")
                .header("X-Forwarded-For", "1")
                .accept(MediaType.APPLICATION_JSON)
                .exchange()
                .expectStatus()
                .is2xxSuccessful();
    }

}

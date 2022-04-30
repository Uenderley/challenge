package com.uenderley.challenge.controller;

import com.uenderley.challenge.facade.FacadeV1;
import com.uenderley.challenge.model.dto.PessoaDTO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;


@RestController
@AllArgsConstructor
@Api(tags = "Challenge Rest Controller - V1")
@RequestMapping(value = "v1", produces = MediaType.APPLICATION_JSON_VALUE)
public class ChallengeControllerV1 {
    @Autowired
    FacadeV1 facadeV1;

    @ApiOperation(value = "Retorna todas as pessoas", produces = MediaType.APPLICATION_JSON_VALUE)
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public Flux<PessoaDTO> findAll() {
        return facadeV1.findAll();
    }

    @ApiOperation(value = "Retorna a pessoa pelo ID", produces = MediaType.APPLICATION_JSON_VALUE)
    @GetMapping("/id")
    public Mono<PessoaDTO> findById(@RequestParam Integer idPessoa) {
        return facadeV1.findById(idPessoa);
    }

    @PostMapping("")
    @ApiOperation(value = "Return the available delivery options")
    public Mono<PessoaDTO> savePerson(@RequestBody PessoaDTO pessoaDTO) {
        return facadeV1.save(pessoaDTO);
    }

    @PostMapping("/update")
    @ApiOperation(value = "Return the available delivery options")
    public Mono<Void> update(@RequestBody PessoaDTO pessoaDTO) {
        return facadeV1.update(pessoaDTO);
    }

    @PatchMapping("")
    @ApiOperation(value = "Return the available delivery options")
    public Mono<Void> updateStatus(@RequestBody PessoaDTO pessoaDTO) {
        return facadeV1.updateStatus(pessoaDTO);
    }
}

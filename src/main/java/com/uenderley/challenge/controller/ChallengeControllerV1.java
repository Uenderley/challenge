package com.uenderley.challenge.controller;

import com.uenderley.challenge.facade.FacadeV1;
import com.uenderley.challenge.model.dto.request.PessoaDTO;
import com.uenderley.challenge.model.dto.response.PessoaResponseDTO;
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
    public Flux<PessoaResponseDTO> findAll() {
        return facadeV1.findAll();
    }

    @ApiOperation(value = "Retorna a pessoa pelo ID", produces = MediaType.APPLICATION_JSON_VALUE)
    @GetMapping("/id")
    public Mono<PessoaResponseDTO> findById(@RequestParam Integer idPessoa) {
        return facadeV1.findById(idPessoa);
    }

    @PostMapping("")
    @ApiOperation(value = "Salvar uma pessoa")
    public Mono<PessoaResponseDTO> savePerson(@RequestBody PessoaDTO pessoaDTO) {
        return facadeV1.save(pessoaDTO);
    }

    @PostMapping("/update")
    @ApiOperation(value = "Atualizar uma pessoa")
    public Mono<Void> update(@RequestBody PessoaDTO pessoaDTO) {
        return facadeV1.update(pessoaDTO);
    }

    @PatchMapping("")
    @ApiOperation(value = "Return the available delivery options")
    public Mono<Void> updateStatus(@RequestBody PessoaDTO pessoaDTO) {
        return facadeV1.updateStatus(pessoaDTO);
    }

    @DeleteMapping("")
    @ApiOperation(value = "Deletar uma pessoa")
    public Mono<Void> delete(@RequestParam Integer idPessoa) {
         return facadeV1.deleteById(idPessoa);
    }
}

package com.uenderley.challenge.stub;

import com.uenderley.challenge.model.dto.PessoaDTO;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class PessoaDTOStub {
    public static PessoaDTO build() {
        return PessoaDTO.builder()
                .nome("NomePessoa")
                .sobrenome("Sobrenome")
                .email("mail")
                .cpf("9999999999")
                .ativo(Boolean.TRUE)
                .build();
    }

    public static List<PessoaDTO> builder(int size){
        List<PessoaDTO> pessoas = new ArrayList<>();
        for (int tamanho = 0 ; tamanho < size; tamanho++) {
            pessoas.add(build());
        }
        return pessoas;
    }
}
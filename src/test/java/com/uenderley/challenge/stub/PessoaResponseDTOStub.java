package com.uenderley.challenge.stub;

import com.uenderley.challenge.model.dto.response.PessoaResponseDTO;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class PessoaResponseDTOStub {
    public static PessoaResponseDTO build() {
        return PessoaResponseDTO.builder()
                .nome("NomePessoa")
                .sobrenome("Sobrenome")
                .email("mail")
                .cpf("9999999999")
                .ativo(Boolean.TRUE)
                .build();
    }

    public static List<PessoaResponseDTO> builder(int size){
        List<PessoaResponseDTO> pessoas = new ArrayList<>();
        for (int tamanho = 0 ; tamanho < size; tamanho++) {
            pessoas.add(build());
        }
        return pessoas;
    }
}
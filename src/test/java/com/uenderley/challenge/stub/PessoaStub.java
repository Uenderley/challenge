package com.uenderley.challenge.stub;

import com.uenderley.challenge.model.Pessoa;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class PessoaStub {
    public static Pessoa build() {
        return Pessoa.builder()
                .id(0)
                .nome("NomePessoa")
                .sobrenome("Sobrenome")
                .email("mail")
                .cpf("9999999999")
                .ativo(Boolean.TRUE)
                .build();
    }

    public static List<Pessoa> builder(int size){
        List<Pessoa> pessoas = new ArrayList<>();
        for (int tamanho = 0 ; tamanho < size; tamanho++) {
            pessoas.add(build());
        }
        return pessoas;
    }
}

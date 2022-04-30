package com.uenderley.challenge.model.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PessoaDTO {
    private String nome;
    private String sobrenome;
    private String email;
    private String cpf;
    private boolean ativo;
}

package com.uenderley.challenge.model.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PessoaResponseDTO {
    private int id;
    private String nome;
    private String sobrenome;
    private String email;
    private String cpf;
    private boolean ativo;
}

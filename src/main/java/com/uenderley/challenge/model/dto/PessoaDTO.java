package com.uenderley.challenge.model.dto;

import lombok.Data;

@Data
public class PessoaDTO {
    private String nome;
    private String sobrenome;
    private String email;
    private String cpf;
    private boolean ativo;
}

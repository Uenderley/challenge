package com.uenderley.challenge.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Table
@Data
public class Pessoa {
    @Id
    private Integer id;
    @Column
    private String nome;
    @Column
    private String sobrenome;
    @Column
    private String email;
    @Column
    private String cpf;
    @Column
    private boolean ativo;
}

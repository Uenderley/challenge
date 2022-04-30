package com.uenderley.challenge.model.mapper;

import com.uenderley.challenge.model.Pessoa;
import com.uenderley.challenge.model.dto.PessoaDTO;
import org.mapstruct.Mapper;

@Mapper
public interface PessoaMapper {
    PessoaDTO mapper(Pessoa pessoa);
    Pessoa mapper(PessoaDTO pessoaDTO);
}

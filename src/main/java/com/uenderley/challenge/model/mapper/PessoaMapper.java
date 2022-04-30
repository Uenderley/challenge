package com.uenderley.challenge.model.mapper;

import com.uenderley.challenge.model.Pessoa;
import com.uenderley.challenge.model.dto.request.PessoaDTO;
import com.uenderley.challenge.model.dto.response.PessoaResponseDTO;
import org.mapstruct.Mapper;

@Mapper
public interface PessoaMapper {
    Pessoa mapper(PessoaDTO pessoaDTO);
    PessoaResponseDTO mapper(Pessoa pessoa);
}

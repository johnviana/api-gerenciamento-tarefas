package com.api.tarefas.domain.dtos;

import com.api.tarefas.domain.model.Pessoa;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.BeanUtils;

import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
public class PessoaDto {

    private UUID idPessoa;
    private String nome;
    private String departamento;
    private TarefaDto tarefas;

    public PessoaDto(){}

    public PessoaDto(Pessoa entity){
        BeanUtils.copyProperties(entity, this);
    }

}

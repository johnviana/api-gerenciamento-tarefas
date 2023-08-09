package com.api.tarefas.domain.dtos;

import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class PessoaDto {

    private UUID idPessoa;

    private String nome;

    private String departamento;

    private TarefaDto tarefas;
}

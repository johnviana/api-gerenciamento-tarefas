package com.api.tarefas.domain.dtos;

import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class TarefaDto {

    private UUID idTarefa;

    private String titulo;

    private String descricao;

    private String prazo;

    private String duracao;

    private boolean finalizado;

    private PessoaDto pessoa;
}

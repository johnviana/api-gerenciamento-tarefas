package com.api.tarefas.domain.dtos;

import java.util.UUID;


public class TarefaDto {

    private UUID idTarefa;

    private String titulo;

    private String descricao;

    private String prazo;

    private String duracao;

    private boolean finalizado;

    private PessoaDto pessoaAlocada;
}

package com.api.tarefas.domain.dtos;

import com.api.tarefas.domain.model.Tarefa;
import jakarta.persistence.*;

import java.util.List;
import java.util.UUID;

public class PessoaDto {


    private UUID idPessoa;

    @Column
    private String nome;

    @Column
    private String departamento;

    @OneToMany(mappedBy = "pessoaAlocada")
    private List<Tarefa> tarefas;
}

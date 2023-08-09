package com.api.tarefas.domain.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.UUID;

@Data
@Entity
@Table(name = "tarefa")
public class Tarefa {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column
    private UUID idTarefa;

    @Column
    private String titulo;

    @Column
    private String descricao;

    @Column
    private String prazo;

    @Column
    private String duracao;

    private boolean finalizado;

    @ManyToMany
    @JoinColumn(name = "pessoa_id")
    private Pessoa pessoaAlocada;
}

package com.api.tarefas.domain.model;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "pessoa")
@Data
public class Pessoa implements Serializable {

    private static final long serialVersionUID = 1l;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID idPessoa;

    @Column
    private String nome;

    @Column
    private String departamento;

    @OneToMany(mappedBy = "pessoaAlocada")
    private List<Tarefa> tarefas;

}

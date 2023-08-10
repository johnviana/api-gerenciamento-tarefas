package com.api.tarefas.domain.model;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;

@Data
@Entity
@Table(name = "tarefa")
public class Tarefa implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_terefa")
    private Long id;

    @Column
    private String titulo;

    @Column
    private String descricao;

    @Column
    private String prazo;

    @Column
    private String duracao;

    private boolean finalizado;

//    @JsonIgnoreProperties(value = "nome", allowGetters = true )
    @ManyToOne
    @JoinColumn(name = "pessoa_id")
    private Pessoa pessoa;
}

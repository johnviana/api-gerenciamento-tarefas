package com.api.tarefas.domain.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "pessoa")
@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Pessoa implements Serializable {

    private static final long serialVersionUID = 1l;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_pessoa")
    private Long id;

    @Column(name = "nome")
    private String nome;

    @Column(name = "departamento")
    private String departamento;

//  @JsonIgnore
    @OneToMany(mappedBy = "pessoa")
    private List<Tarefa> tarefa = new ArrayList<>();


}

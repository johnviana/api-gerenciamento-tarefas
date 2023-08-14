package com.api.tarefas.domain.model;

import java.math.BigDecimal;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@Entity
@Table(name = "pessoa")
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Pessoa  {

    @Id
    @EqualsAndHashCode.Include
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(name = "nome", nullable = false)
    private String nome;
    
    @Column
    private long periodo;
    
    @ManyToOne
    @JoinColumn(name = "departamento_id")
    private Departamento departamento;
    
    private long totalHorasGastas;
    
    @JsonIgnore
    @OneToMany(mappedBy = "pessoaAlocada")
    private List<Tarefa> tarefas;
    

}

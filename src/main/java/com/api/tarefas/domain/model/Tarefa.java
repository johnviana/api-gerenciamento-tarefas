package com.api.tarefas.domain.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.EqualsAndHashCode;

@Entity
@Table(name = "tarefa")
public class Tarefa {

	public Tarefa() {}
	
    @Id
    @EqualsAndHashCode.Include
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
 
    @Column
    private String titulo;

    @Column
    private String descricao;

    @Column
    private String prazo;
    
    @Column
    private String departamento;

    @Column
    private String duracao;
    
    private int totalHora;
   
    private boolean ativo = Boolean.TRUE;
    
    @ManyToOne
    @JoinColumn(name = "pessoa_id")
    private Pessoa pessoaAlocada;
        
    public void ativar() {
    	setAtivo(true);
    }
    
    public void finalizar() {
    	setAtivo(false);
    }

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getPrazo() {
		return prazo;
	}

	public void setPrazo(String prazo) {
		this.prazo = prazo;
	}

	public String getDepartamento() {
		return departamento;
	}

	public void setDepartamento(String departamento) {
		this.departamento = departamento;
	}

	public String getDuracao() {
		return duracao;
	}

	public void setDuracao(String duracao) {
		this.duracao = duracao;
	}

	public boolean isAtivo() {
		return ativo;
	}

	public void setAtivo(boolean ativo) {
		this.ativo = ativo;
	}

	public Pessoa getPessoaAlocada() {
		return pessoaAlocada;
	}

	public void setPessoaAlocada(Pessoa pessoaAlocada) {
		this.pessoaAlocada = pessoaAlocada;
	}
	
	
	public void alocarPessoaComMesmoDepartamento(Pessoa pessoa) {
	    if (pessoa.getDepartamento().equals(this.departamento)) {
	        this.pessoaAlocada = pessoa;
	    } else {
	        throw new IllegalArgumentException("A pessoa não pertence ao mesmo departamento da tarefa.");
	    }
	}

	
	public Tarefa(Long id,  String titulo,  String descricao,  String prazo,
			 String departamento,  String duracao, int totalHora, boolean ativo, Pessoa pessoaAlocada) {
		super();
		this.id = id;
		this.titulo = titulo;
		this.descricao = descricao;
		this.prazo = prazo;
		this.departamento = departamento;
		this.duracao = duracao;
		this.totalHora = totalHora;
		this.ativo = ativo;
		this.pessoaAlocada = pessoaAlocada;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Tarefa other = (Tarefa) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	public int getTotalHora() {
		return totalHora;
	}

	public void setTotalHora(int totalHora) {
		this.totalHora = totalHora;
	}
	
}

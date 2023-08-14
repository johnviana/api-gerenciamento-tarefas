package com.api.tarefas.domain.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PessoaDto {
	
    
	public PessoaDto(String nome, String departamento, long totalHorasGastas) {
		super();
		this.nome = nome;
		this.departamento = departamento;
		this.totalHorasGastas = totalHorasGastas;
	}
	
	
	private String nome;
    private String departamento;
    private long totalHorasGastas;

    
}
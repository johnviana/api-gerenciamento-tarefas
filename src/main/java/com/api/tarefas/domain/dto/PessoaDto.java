package com.api.tarefas.domain.dto;

import java.math.BigDecimal;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PessoaDto {
	
	private String nome;
	private long periodo;
	private DepartamentoDto departamento;
    private long totalHorasGastas;

    
}
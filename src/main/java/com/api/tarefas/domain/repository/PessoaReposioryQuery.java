package com.api.tarefas.domain.repository;

import java.math.BigDecimal;
import java.util.List;

import com.api.tarefas.domain.model.Pessoa;

public interface PessoaReposioryQuery {

	List<Pessoa> find(String nome, BigDecimal periodoInicial, BigDecimal periodoFinal);

}
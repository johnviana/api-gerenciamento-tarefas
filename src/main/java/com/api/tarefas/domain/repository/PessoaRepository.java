package com.api.tarefas.domain.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.api.tarefas.domain.model.Pessoa;

@Repository
public interface PessoaRepository extends JpaRepository<Pessoa, Long> {
    
	List<Pessoa> findByDepartamentoNome(String departamento);
  
	List<Pessoa> findByNomeAndDepartamentoNome(String nome, String departamento);
	
	
	@Query("SELECT p.nome, p.departamento, COALESCE(SUM(t.duracao), 0) FROM Pessoa p LEFT JOIN p.tarefas t GROUP BY p.id")
    List<Object[]> listarPessoasInfo();
    
    long count();
}

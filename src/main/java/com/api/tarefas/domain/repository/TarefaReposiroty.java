package com.api.tarefas.domain.repository;

import com.api.tarefas.domain.model.Tarefa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TarefaReposiroty extends JpaRepository<Tarefa, Long> {
	
}

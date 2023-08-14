package com.api.tarefas.domain.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.tarefas.domain.excepetion.TarefaNaoEncontradaException;
import com.api.tarefas.domain.model.Pessoa;
import com.api.tarefas.domain.model.Tarefa;
import com.api.tarefas.domain.repository.TarefaReposiroty;

import jakarta.transaction.Transactional;

@Service
public class TarefaService {

    @Autowired
    private TarefaReposiroty tarefaReposiroty;
    
    @Autowired
    private PessoaService pessoaService;


    @Transactional
    public Tarefa salvar(Tarefa tarefa) {
        Long pessoaId = tarefa.getPessoaAlocada().getId();

        Pessoa pessoa = pessoaService.buscarOuFalhar(pessoaId);
        
        tarefa.setPessoaAlocada(pessoa);

        return tarefaReposiroty.save(tarefa);
    }
     

    public Tarefa buscarOuFalhar(Long id){
        return tarefaReposiroty.findById(id)
                .orElseThrow(() -> new TarefaNaoEncontradaException(id));
    }
    
    @Transactional
    public void ativar(Long tarefaId) {
    	Tarefa tarefaAtual = buscarOuFalhar(tarefaId);	
    	tarefaAtual.ativar();
    }
    
    @Transactional
    public void finalizar(Long tarefaId) {
    	Tarefa tarefaAtual = buscarOuFalhar(tarefaId);
    	tarefaAtual.finalizar();
    }
}

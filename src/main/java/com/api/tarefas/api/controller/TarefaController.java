package com.api.tarefas.api.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.api.tarefas.domain.model.Pessoa;
import com.api.tarefas.domain.model.Tarefa;
import com.api.tarefas.domain.repository.PessoaRepository;
import com.api.tarefas.domain.repository.TarefaReposiroty;
import com.api.tarefas.domain.service.TarefaService;

@RestController
@RequestMapping(value = "/tarefas")
public class TarefaController {

    @Autowired
    private TarefaReposiroty tarefaRepository;
    
    @Autowired
    private PessoaRepository pessoaRepository;

    @Autowired
    private TarefaService tarefaService;

    @GetMapping
    public List<Tarefa> listar(){
        return tarefaRepository.findAll();
    }

    @GetMapping("/{id}")
    public Tarefa buscarTarefa(@PathVariable Long id){
        return tarefaService.buscarOuFalhar(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Tarefa adicionar(@RequestBody Tarefa tarefa) {
        return tarefaService.salvar(tarefa);
    }
    
  
    @PutMapping("/alocar/{id}")
    public ResponseEntity<String> alocarPessoaATarefa(@PathVariable Long id) {
        Optional<Tarefa> optionalTarefa = tarefaRepository.findById(id);

        if (!optionalTarefa.isPresent()) {
            return ResponseEntity.notFound().build();
        }

        Tarefa tarefa = optionalTarefa.get();
        String departamentoNome = tarefa.getDepartamento();

        List<Pessoa> pessoasDoDepartamento = pessoaRepository.findByDepartamento(departamentoNome);
        
        for (Pessoa pessoa : pessoasDoDepartamento) {
            if (pessoa.getTarefas().isEmpty()) {
                pessoa.getTarefas().add(tarefa);
                tarefa.setPessoaAlocada(pessoa);
                tarefaService.salvar(tarefa);
                return ResponseEntity.ok("Pessoa alocada com sucesso!");
            }
        }

        return ResponseEntity.badRequest().body("Não foi possível alocar uma pessoa na tarefa.");
    }

    
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PutMapping("/{tarefaId}")
    public void ativar(@PathVariable Long tarefaId) {
    	tarefaService.ativar(tarefaId);
    }
    
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{tarefaId}")
    public void finalizar(@PathVariable Long tarefaId) {
    	tarefaService.finalizar(tarefaId);
    }

}

package com.api.tarefas.api.controller;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.BeanUtils;
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

import com.api.tarefas.domain.dto.PessoaDto;
import com.api.tarefas.domain.excepetion.EntidadeNaoEncontradaException;
import com.api.tarefas.domain.excepetion.NegocioException;
import com.api.tarefas.domain.excepetion.TarefaNaoEncontradaException;
import com.api.tarefas.domain.model.Pessoa;
import com.api.tarefas.domain.repository.PessoaRepository;
import com.api.tarefas.domain.service.PessoaService;

@RestController
@RequestMapping(value = "/pessoas")
public class PessoaController {

    @Autowired
    private PessoaService pessoaService;
     
    @Autowired
    private PessoaRepository pessoaRepository;
    
    
    @GetMapping
    public List<Pessoa> listarPessoas(){
    	return pessoaRepository.findAll();
    }
    
    @GetMapping("/{id}")
    public Pessoa buscarPessoa(@PathVariable Long id) {
    	return pessoaService.buscarOuFalhar(id);
    }
    
    @PostMapping
    public ResponseEntity<?> salvarPessoa(@RequestBody PessoaDto pessoaDto){
    	var pessoa = new Pessoa();
    	BeanUtils.copyProperties(pessoaDto, pessoa);
    	return ResponseEntity.status(HttpStatus.CREATED).body(pessoaService.salvar(pessoa));
    }
    

    @PutMapping("/{id}")
	public Pessoa atualizar(@PathVariable Long id,
			@RequestBody Pessoa pessoa) {
		try {
			Pessoa pessoaAtual = pessoaService.buscarOuFalhar(id);
			
			BeanUtils.copyProperties(pessoa, pessoaAtual, "id");

			return pessoaService.salvar(pessoaAtual);
		} catch (TarefaNaoEncontradaException e) {
			throw new NegocioException(e.getMessage());
		}
	}
        
    
    @DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void remover(@PathVariable Long id) {
    	
    	try {
    		this.pessoaService.excluir(id);	
			
		} catch (Exception e) {
			throw new EntidadeNaoEncontradaException(String.format("Entidade nao encontrada", id)) {

				private static final long serialVersionUID = 1L;
			};
		}
	}
    
    @GetMapping("/nome/periodo")
    public List<Pessoa> listarNomePeriodo(String nome, BigDecimal periodoInicio, 
    		BigDecimal periodoFinal){
    	return pessoaRepository.find(nome, periodoInicio, periodoFinal);
    }
    

}


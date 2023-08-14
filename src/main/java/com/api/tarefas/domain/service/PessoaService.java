package com.api.tarefas.domain.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.api.tarefas.domain.excepetion.EntidadeEmUsoException;
import com.api.tarefas.domain.excepetion.PessoaNaoEncontradaException;
import com.api.tarefas.domain.model.Pessoa;
import com.api.tarefas.domain.repository.PessoaRepository;

import jakarta.transaction.Transactional;

@Service
public class PessoaService {

	private static final String MSG_PESSOA_NAO_ENCONTRADO = 
	        "Não existe um cadastro de pessoa com código %d";
	
    @Autowired
    private PessoaRepository pessoaRepository;

  
    @Transactional
    public Pessoa salvar(Pessoa pessoa) {
        return pessoaRepository.save(pessoa);
    }
    
    
    public Pessoa buscarOuFalhar(Long id) {
        return pessoaRepository.findById(id)
            .orElseThrow(() -> new PessoaNaoEncontradaException(
                    String.format(MSG_PESSOA_NAO_ENCONTRADO, id)));
    }
    
  
    
    @Transactional
	public void excluir(Long id) {
		try {
			pessoaRepository.deleteById(id);
			pessoaRepository.flush();
			
		} catch (EmptyResultDataAccessException e) {
			throw new PessoaNaoEncontradaException(
					String.format(MSG_PESSOA_NAO_ENCONTRADO, id));
		
		} catch (DataIntegrityViolationException e) {
			throw new EntidadeEmUsoException(
				String.format("Entidade em uso ", id));
		}
	}
    
    

}

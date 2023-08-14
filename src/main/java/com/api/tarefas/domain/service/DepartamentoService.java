package com.api.tarefas.domain.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.tarefas.domain.repository.DepartamentoRepository;

@Service
public class DepartamentoService {

	@Autowired
	private DepartamentoRepository departamentoRepository; 
	
	public long contarDepartamentos() {
        return departamentoRepository.count();
    }
	
//	public Departamento buscarOuFalhar(Long Id) {
//		return departamentoRepository.findById(Id)
//			.orElseThrow(() -> new EntidadeNaoEncontradaException(Id));
//	}
	
}
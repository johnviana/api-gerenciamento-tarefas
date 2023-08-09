package com.api.tarefas.domain.service;

import com.api.tarefas.domain.dtos.PessoaDto;
import com.api.tarefas.domain.model.Pessoa;
import com.api.tarefas.domain.repository.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Service
public class PessoaService {

    @Autowired
    private PessoaRepository pessoaRepository;

    @Transactional(readOnly = true)
    public List<PessoaDto> findAll(){
        List<Pessoa> result =  pessoaRepository.findAll();
        return result.stream().map(PessoaDto::new).toList();
//        return result.stream().map(x -> new PessoaDto(x)).toList();
    }

    @Transactional(readOnly = true)
    public PessoaDto findById(UUID id){
        Pessoa result = pessoaRepository.findById(id).get();
        return new PessoaDto(result);

    }

    @Transactional(readOnly = true)
    public Pessoa salvar(Pessoa pessoa) {
        return pessoaRepository.save(pessoa);
    }

}

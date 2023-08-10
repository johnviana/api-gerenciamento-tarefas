package com.api.tarefas.api.controller;

import com.api.tarefas.domain.model.Pessoa;
import com.api.tarefas.domain.service.PessoaService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/pessoa")
public class PessoaController {

    @Autowired
    private PessoaService pessoaService;

//    @GetMapping
//    public List<PessoaDto> findAll(){
//        List<PessoaDto> result = pessoaService.findAll();
//        return result;
//    }
//
//    @GetMapping(value = "/{id}")
//    public PessoaDto findById(@PathVariable Long id){
//        return pessoaService.findById(id);
//    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Pessoa salvarCozinhar(@RequestBody @Valid Pessoa pessoa ){
        Pessoa pessoaSalva = pessoaService.salvar(pessoa);
        return pessoaService.salvar(pessoaSalva);

    }

}

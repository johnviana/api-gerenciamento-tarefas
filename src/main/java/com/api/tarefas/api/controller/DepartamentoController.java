package com.api.tarefas.api.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.tarefas.domain.service.DepartamentoService;
import com.api.tarefas.domain.service.PessoaService;
import com.api.tarefas.domain.service.TarefaService;

@RestController
@RequestMapping("/departamento")
public class DepartamentoController {
	
	@Autowired
    private PessoaService pessoaService;
	@Autowired
	private TarefaService tarefaService;
	@Autowired
	private DepartamentoService departamentoService;

   
    @GetMapping
    public ResponseEntity<Map<String, Long>> obterEstatisticas() {
        try {
            long quantidadePessoas = pessoaService.contarPessoas();
            long quantidadeTarefas = tarefaService.contarTarefas();
            long quantidadeDepartamentos = departamentoService.contarDepartamentos();

            Map<String, Long> estatisticas = new HashMap<>();
            estatisticas.put("quantidadePessoas", quantidadePessoas);
            estatisticas.put("quantidadeTarefas", quantidadeTarefas);
            estatisticas.put("quantidadeDepartamentos", quantidadeDepartamentos);

            return ResponseEntity.ok(estatisticas);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }
}
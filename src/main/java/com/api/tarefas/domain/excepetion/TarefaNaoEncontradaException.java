package com.api.tarefas.domain.excepetion;

import java.io.Serial;

public class TarefaNaoEncontradaException extends EntidadeNaoEncontradaException {

    @Serial
    private static final long serialVersionUID = 1L;

    public TarefaNaoEncontradaException(String mensagem) {
        super(mensagem);
    }
    public TarefaNaoEncontradaException(Long id) {
        this(String.format("Não existe um cadastro de Tarefa com código %d", id));
    }

}
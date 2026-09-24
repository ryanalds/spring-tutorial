package com.exemplo.tarefas.factory;

import  com.exemplo.tarefas.dto.*;
import  com.exemplo.tarefas.model.Tarefa;
import org.springframework.stereotype.Component;


@Component 
public class TarefaFactory {
    
    public Tarefa criar(TarefaRequest request){
        return new Tarefa(request.titulo().trim()); //trim() garante  que o titulo nao possua espaço nas pontas
    }

    public TarefaResponse paraResponse(Tarefa t){
        return new TarefaResponse(t.getId(), t.getTitulo(), t.isConcluida());
    }
}

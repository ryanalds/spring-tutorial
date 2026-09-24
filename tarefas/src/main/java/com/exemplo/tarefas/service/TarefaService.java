package com.exemplo.tarefas.service;

import com.exemplo.tarefas.dto.*;
import com.exemplo.tarefas.factory.TarefaFactory;
import com.exemplo.tarefas.model.Tarefa;
import com.exemplo.tarefas.repository.TarefaRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class TarefaService {

    private final TarefaRepository repository;
    private final TarefaFactory factory;

    // Injeção por construtor (melhor prática, dispensa @Autowired)
    public TarefaService(TarefaRepository repository, TarefaFactory factory) {
        this.repository = repository;
        this.factory = factory;
    }

    public TarefaResponse criar(TarefaRequest request) {
        Tarefa salva = repository.save(factory.criar(request));
        return factory.paraResponse(salva);
    }

    public List<TarefaResponse> listar() {
        return repository.findAll().stream().map(factory::paraResponse).toList();
    }

    public TarefaResponse concluir(Long id) {
        Tarefa tarefa = repository.findById(id)
            .orElseThrow(() -> new ResponseStatusException(
                HttpStatus.NOT_FOUND, "Tarefa não encontrada"));
        tarefa.setConcluida(true);
        return factory.paraResponse(repository.save(tarefa));
    }

    public void deletar(Long id) {
        if (!repository.existsById(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Tarefa não encontrada");
        }
        repository.deleteById(id);
    }
}
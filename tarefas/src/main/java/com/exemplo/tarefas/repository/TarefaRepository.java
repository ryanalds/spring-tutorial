package com.exemplo.tarefas.repository;

import com.exemplo.tarefas.model.Tarefa;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;


public interface TarefaRepository extends JpaRepository<Tarefa, Long> {

    List<Tarefa> findByConcluida(Boolean concluida); //query derivado do nome
}

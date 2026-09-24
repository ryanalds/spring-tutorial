package com.exemplo.tarefas.dto;

import jakarta.validation.constraints.NotBlank;

public record TarefaRequest(@NotBlank String titulo) {} //@NotBlank informa que o titulo nao pode ser null
package br.com.rafaelvpds.desafio.dtos;

import jakarta.validation.constraints.NotEmpty;

public record TodoListDto(@NotEmpty String name, @NotEmpty String description, int priority,
                int statusTodos) {

}

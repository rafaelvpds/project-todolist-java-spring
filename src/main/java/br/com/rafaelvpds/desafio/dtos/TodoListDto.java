package br.com.rafaelvpds.desafio.dtos;

import org.hibernate.validator.constraints.Length;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record TodoListDto(
        @NotNull @NotBlank @Length(min = 5, max = 50) String title,
        @NotNull @NotBlank @Length(min = 5, max = 50) String description,
        boolean isCompleted,
        @NotNull @NotBlank String category,
        @NotNull @NotBlank String statusTodo) {

}

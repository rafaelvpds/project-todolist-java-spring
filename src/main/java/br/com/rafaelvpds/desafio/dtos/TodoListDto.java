package br.com.rafaelvpds.desafio.dtos;

import org.hibernate.validator.constraints.Length;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public record TodoListDto(
                @NotNull @NotBlank @Length(min = 5, max = 50) String title,
                @NotNull @NotBlank @Length(min = 5, max = 50) String description,
                boolean isCompleted,
                @NotNull @NotBlank @Pattern(regexp = "WORK|STUDY|PERSONAL") String category,
                @NotNull @NotBlank @Pattern(regexp = "STOPED|PROGRESS|FINISHED") String statusTodo) {

}

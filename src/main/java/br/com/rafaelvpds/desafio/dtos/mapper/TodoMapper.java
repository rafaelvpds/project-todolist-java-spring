package br.com.rafaelvpds.desafio.dtos.mapper;

import org.springframework.stereotype.Component;

import br.com.rafaelvpds.desafio.dtos.TodoListDto;
import br.com.rafaelvpds.desafio.entities.TodoList;
import br.com.rafaelvpds.desafio.enums.CategoryTodo;
import br.com.rafaelvpds.desafio.enums.StatusTodo;

@Component
public class TodoMapper {

    public TodoListDto toDto(TodoList todoList) {
        if (todoList == null) {
            return null;
        }
        return new TodoListDto(todoList.getTitle(), todoList.getDescription(), todoList.getIsCompleted(),
                todoList.getCategory().getCategoryTodo(), todoList.getStatusTodo().getCodeStatus());
    }

    public TodoList toEntity(TodoListDto todoListDto) {
        if (todoListDto == null) {
            return null;
        }
        var todoList = new TodoList();
        todoList.setTitle(todoListDto.title());
        todoList.setDescription(todoListDto.description());
        todoList.setIsCompleted(false);
        todoList.setStatusTodo(converterStatusTodo(todoListDto.statusTodo()));
        todoList.setCategory(converterCategoryValue(todoListDto.category()));

        return todoList;

    }

    public StatusTodo converterStatusTodo(String code) {
        if (code == null) {
            return null;
        }
        return switch (code) {
            case "Parado" -> StatusTodo.STOPED;
            case "Em andamento" -> StatusTodo.PROGRESS;
            case "Concluido" -> StatusTodo.FINISHED;

            default -> throw new IllegalArgumentException("Ivalid code :" + code);

        };
    }

    public CategoryTodo converterCategoryValue(String value) {
        if (value == null) {
            return null;
        }
        return switch (value) {
            case "Work" -> CategoryTodo.WORK;
            case "Study" -> CategoryTodo.STUDY;
            case "Pessoal" -> CategoryTodo.PERSONAL;
            default -> throw new IllegalArgumentException("Ivalid code :" + value);
        };
    }

}

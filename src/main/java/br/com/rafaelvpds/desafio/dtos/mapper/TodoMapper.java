package br.com.rafaelvpds.desafio.dtos.mapper;

import org.springframework.stereotype.Component;

import br.com.rafaelvpds.desafio.dtos.TodoListDto;
import br.com.rafaelvpds.desafio.entities.TodoList;

@Component
public class TodoMapper {

    public TodoListDto toDto(TodoList todoList) {
        if (todoList == null) {
            return null;
        }
        return new TodoListDto(todoList.getTitle(), todoList.getDescription(), todoList.getIsCompleted(),
                todoList.getCategory(), todoList.getStatusTodo());
    }

    public TodoList toEntity(TodoListDto todoListDto) {
        if (todoListDto == null) {
            return null;
        }
        var todoList = new TodoList();
        todoList.setTitle(todoListDto.title());
        todoList.setDescription(todoListDto.description());
        todoList.setIsCompleted(false);
        todoList.setStatusTodo(todoListDto.statusTodo());
        todoList.setCategory(todoListDto.category());

        return todoList;

    }

}

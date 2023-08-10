package br.com.rafaelvpds.desafio.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import br.com.rafaelvpds.desafio.entities.TodoList;
import br.com.rafaelvpds.desafio.exeption.RecordNotFaundExeption;
import br.com.rafaelvpds.desafio.repository.TodoRepository;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

@Service
public class TodoService {
    @Autowired
    private TodoRepository todoRepository;

    public TodoList create(TodoList todoList) {

        return todoRepository.save(todoList);

    }

    public List<TodoList> findAll() {
        Sort sort = Sort.by("statusTodo").descending().and(
                Sort.by("title").ascending());
        return todoRepository.findAll(sort);
    }

    public TodoList findById(@NotNull @Positive Long id) {

        return todoRepository.findById(id)
                .orElseThrow(() -> new RecordNotFaundExeption(id));
    }

    public TodoList update(Long id, TodoList todoList) {
        return todoRepository.findById(id)
                .map(todoListFound -> {
                    todoListFound.setTitle(todoList.getTitle());
                    todoListFound.setDescription(todoList.getDescription());
                    todoListFound.setIsCompleted(todoList.getIsCompleted());
                    todoListFound.setStatusTodo(todoList.getStatusTodo());
                    todoListFound.setCategory(todoList.getCategory());

                    return todoRepository.save(todoListFound);
                })
                .orElseThrow(() -> new RecordNotFaundExeption(id));

    }

    public void delete(Long id) {
        todoRepository.delete(todoRepository.findById(id)
                .orElseThrow(() -> new RecordNotFaundExeption(id)));
        todoRepository.findById(id);

    }
}

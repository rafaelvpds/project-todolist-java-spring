package br.com.rafaelvpds.desafio.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import br.com.rafaelvpds.desafio.entities.TodoList;
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

    public Optional<TodoList> findById(@NotNull @Positive Long id) {

        return todoRepository.findById(id);
    }

    public Optional<TodoList> update(Long id, TodoList todoList) {
        return todoRepository.findById(id)
                .map(todoListFound -> {
                    todoListFound.setTitle(todoList.getTitle());
                    todoListFound.setDescription(todoList.getDescription());
                    todoListFound.setIsCompleted(todoList.getIsCompleted());
                    todoListFound.setStatusTodo(todoList.getStatusTodo());
                    todoListFound.setCategory(todoList.getCategory());

                    return todoRepository.save(todoListFound);
                });

    }

    public boolean delete(Long id) {
        return todoRepository.findById(id)
                .map(todoFaund -> {
                    todoRepository.deleteById(id);
                    return true;
                })
                .orElse(false);

    }
}

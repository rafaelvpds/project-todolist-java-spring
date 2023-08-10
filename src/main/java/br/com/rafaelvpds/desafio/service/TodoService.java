package br.com.rafaelvpds.desafio.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import br.com.rafaelvpds.desafio.dtos.TodoListDto;
import br.com.rafaelvpds.desafio.dtos.mapper.TodoMapper;
import br.com.rafaelvpds.desafio.exeption.RecordNotFaundExeption;
import br.com.rafaelvpds.desafio.repository.TodoRepository;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

@Validated
@Service
public class TodoService {
    @Autowired
    private TodoRepository todoRepository;
    @Autowired
    private TodoMapper todoMapper;

    public List<TodoListDto> findAll() {
        Sort sort = Sort.by("statusTodo").descending().and(
                Sort.by("title").ascending());
        return todoRepository.findAll(sort).stream()
                .map(todoMapper::toDto)
                .collect(Collectors.toList());
    }

    public TodoListDto findById(@NotNull @Positive Long id) {

        return todoRepository.findById(id)
                .map(todoMapper::toDto)
                .orElseThrow(() -> new RecordNotFaundExeption(id));
    }

    public TodoListDto create(@Valid @NotNull TodoListDto todoList) {

        return todoMapper.toDto(todoRepository.save(todoMapper.toEntity(todoList)));

    }

    public TodoListDto update(Long id, TodoListDto todoList) {
        return todoRepository.findById(id)
                .map(todoListFound -> {
                    todoListFound.setTitle(todoList.title());
                    todoListFound.setDescription(todoList.description());
                    todoListFound.setIsCompleted(todoList.isCompleted());
                    todoListFound.setStatusTodo(todoList.statusTodo());
                    todoListFound.setCategory(todoList.category());

                    return todoRepository.save(todoListFound);
                })
                .map(todoMapper::toDto)
                .orElseThrow(() -> new RecordNotFaundExeption(id));

    }

    public void delete(Long id) {
        todoRepository.delete(todoRepository.findById(id)
                .orElseThrow(() -> new RecordNotFaundExeption(id)));
        todoRepository.findById(id);

    }
}

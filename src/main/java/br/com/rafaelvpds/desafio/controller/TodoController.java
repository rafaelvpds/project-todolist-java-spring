package br.com.rafaelvpds.desafio.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.rafaelvpds.desafio.dtos.TodoListDto;
import br.com.rafaelvpds.desafio.service.TodoService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

@Validated
@RestController
@RequestMapping("/todos")
@CrossOrigin(origins = "*")
public class TodoController {
    @Autowired
    private TodoService todoService;

    @PostMapping
    public ResponseEntity<TodoListDto> create(@RequestBody @Valid TodoListDto todoList) {

        return ResponseEntity.status(HttpStatus.CREATED).body(todoService.create(todoList));
    }

    @GetMapping
    public @ResponseBody List<TodoListDto> list() {
        return todoService.findAll();
    }

    @GetMapping("/{id}")
    public TodoListDto findById(@PathVariable @NotNull @Positive Long id) {
        return todoService.findById(id);

    }

    @PutMapping("/{id}")
    public TodoListDto update(@PathVariable("id") @NotNull @Positive Long id,
            @RequestBody @Valid TodoListDto todoList) {

        return todoService.update(id, todoList);

    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable("id") @NotNull @Positive Long id) {
        todoService.delete(id);
    }
}

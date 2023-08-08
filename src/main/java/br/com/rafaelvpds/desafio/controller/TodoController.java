package br.com.rafaelvpds.desafio.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.rafaelvpds.desafio.entities.TodoList;
import br.com.rafaelvpds.desafio.service.TodoService;

@RestController
@RequestMapping("/todos")
@CrossOrigin(origins = "*")
public class TodoController {
    @Autowired
    private TodoService todoService;

    @PostMapping
    public ResponseEntity<List<TodoList>> create(@RequestBody TodoList todoList) {
        return ResponseEntity.ok().body(todoService.create(todoList));
    }

    @GetMapping
    public ResponseEntity<List<TodoList>> list() {
        return ResponseEntity.ok().body(todoService.findAll());
    }

    @PutMapping("/{id}")
    public ResponseEntity<TodoList> update(@PathVariable("id") Long id, @RequestBody TodoList todoList) {

        return ResponseEntity.status(HttpStatus.CREATED).body(todoService.update(id, todoList));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Long id) {
        todoService.delte(id);
        return ResponseEntity.ok().build();
    }
}

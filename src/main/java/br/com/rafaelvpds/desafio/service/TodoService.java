package br.com.rafaelvpds.desafio.service;

import java.util.List;
import java.util.Optional;

import org.hibernate.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import br.com.rafaelvpds.desafio.entities.TodoList;
import br.com.rafaelvpds.desafio.repository.TodoRepository;

@Service
public class TodoService {
    @Autowired
    private TodoRepository todoRepository;

    public List<TodoList> create(TodoList todoList) {
        todoRepository.save(todoList);
        return findAll();

    }

    public List<TodoList> findAll() {
        Sort sort = Sort.by("priority").descending().and(
                Sort.by("name").ascending());
        return todoRepository.findAll(sort);
    }

    public TodoList findById(Long id) {
        Optional<TodoList> optionalTodo = todoRepository.findById(id);
        return optionalTodo.orElseThrow(() -> new ObjectNotFoundException("id, not found", id));
    }

    public TodoList update(Long id, TodoList todoList) {
        TodoList newTodoList = findById(id);
        upadateData(newTodoList, todoList);
        return todoRepository.save(newTodoList);
    }

    public void delte(Long id) {
        todoRepository.deleteById(id);
    }

    private final void upadateData(TodoList newTodoList, TodoList todoList) {

        newTodoList.setName(todoList.getName());
        newTodoList.setDescription(todoList.getDescription());
        newTodoList.setIsCompleted(todoList.getIsCompleted());
        newTodoList.setPriority(todoList.getPriority());
        newTodoList.setStatusTodos(todoList.getStatusTodos());
    }

}

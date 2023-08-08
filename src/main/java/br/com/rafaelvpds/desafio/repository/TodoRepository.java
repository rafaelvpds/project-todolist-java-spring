package br.com.rafaelvpds.desafio.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.rafaelvpds.desafio.entities.TodoList;

public interface TodoRepository extends JpaRepository<TodoList, Long> {

}

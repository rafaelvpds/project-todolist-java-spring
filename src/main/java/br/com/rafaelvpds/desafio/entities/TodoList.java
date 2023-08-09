package br.com.rafaelvpds.desafio.entities;

import java.io.Serializable;

import br.com.rafaelvpds.desafio.enums.StatusTodos;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "todos")
public class TodoList implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String description;
    private Boolean isCompleted;
    private int priority;
    private int statusTodos;

    public TodoList() {

    }

    public TodoList(String name, String description, Boolean isCompleted, int priority, StatusTodos statusTodos) {
        this.name = name;
        this.description = description;
        this.isCompleted = isCompleted;
        this.priority = priority;
        setStatusTodos(statusTodos);
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Boolean getIsCompleted() {
        return isCompleted;
    }

    public void setIsCompleted(Boolean isCompleted) {
        this.isCompleted = isCompleted;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    public StatusTodos getStatusTodos() {
        return StatusTodos.valueOf(statusTodos);
    }

    public void setStatusTodos(StatusTodos statusTodos) {
        if (statusTodos != null) {

            this.statusTodos = statusTodos.getCode();
        } else {
            System.out.println("Deu erro");
        }

    }

}

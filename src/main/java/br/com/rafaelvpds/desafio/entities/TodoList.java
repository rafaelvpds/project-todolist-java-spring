package br.com.rafaelvpds.desafio.entities;

import java.io.Serializable;

import org.hibernate.validator.constraints.Length;

import br.com.rafaelvpds.desafio.enums.CategoryTodo;
import br.com.rafaelvpds.desafio.enums.StatusTodo;
import br.com.rafaelvpds.desafio.enums.converters.CategoryConverter;
import br.com.rafaelvpds.desafio.enums.converters.StatusTodoConverter;
import jakarta.persistence.Column;
import jakarta.persistence.Convert;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "todos")
public class TodoList implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @NotBlank
    @Length(min = 5, max = 50)
    @Column(length = 25, nullable = false)
    private String title;

    @NotNull
    @NotBlank
    @Length(min = 5, max = 50)
    @Column(length = 50, nullable = false)
    private String description;

    @Column(nullable = false)
    private boolean isCompleted;

    @NotNull

    @Column(nullable = false)

    @Convert(converter = CategoryConverter.class)
    private CategoryTodo category;

    @Convert(converter = StatusTodoConverter.class)
    private StatusTodo statusTodo;

    public TodoList() {
    }

    public TodoList(String title, String description, boolean isCompleted, CategoryTodo category,
            StatusTodo statusTodo) {
        this.title = title;
        this.description = description;
        this.isCompleted = isCompleted;
        this.statusTodo = statusTodo;
        this.category = category;

    }

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean getIsCompleted() {
        return isCompleted;
    }

    public void setIsCompleted(boolean isCompleted) {
        this.isCompleted = isCompleted;
    }

    public CategoryTodo getCategory() {
        return category;
    }

    public void setCategory(CategoryTodo category) {
        this.category = category;
    }

    public StatusTodo getStatusTodo() {
        return statusTodo;
    }

    public void setStatusTodo(StatusTodo statusTodo) {
        this.statusTodo = statusTodo;
    }

}

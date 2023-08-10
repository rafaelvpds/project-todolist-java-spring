package br.com.rafaelvpds.desafio.entities;

import java.io.Serializable;

import org.hibernate.validator.constraints.Length;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

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
    @NotBlank
    @Column(nullable = false)
    @Pattern(regexp = "WORK|STUDY|PERSONAL")
    private String category;

    @NotNull
    @NotBlank
    @Pattern(regexp = "STOPED|PROGRESS|FINISHED")
    private String statusTodo;

    public TodoList() {
    }

    public TodoList(String title, String description, boolean isCompleted, String category,
            String statusTodo) {
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

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getStatusTodo() {
        return statusTodo;
    }

    public void setStatusTodo(String statusTodo) {
        this.statusTodo = statusTodo;
    }

}

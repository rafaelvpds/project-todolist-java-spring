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
    private String descricao;
    private Boolean realizados;
    private int prioridade;
    private Integer statusTodos;

    public TodoList() {

    }

    public TodoList(String name, String descricao, Boolean realizados, int prioridade, Integer statusTodos) {

        this.name = name;
        this.descricao = descricao;
        this.realizados = realizados;
        this.prioridade = prioridade;
        this.statusTodos = statusTodos;
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

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Boolean getRealizados() {
        return realizados;
    }

    public void setRealizados(Boolean realizados) {
        this.realizados = realizados;
    }

    public int getPrioridade() {
        return prioridade;
    }

    public void setPrioridade(int prioridade) {
        this.prioridade = prioridade;
    }

    public Boolean isRealizados() {
        return this.realizados;
    }

    public StatusTodos getStatusTodos() {
        return StatusTodos.valueOf(statusTodos);
    }

    public void setStatusTodos(StatusTodos statusTodos) {
        if (statusTodos != null) {

            this.statusTodos = statusTodos.getCode();
        }
    }

}

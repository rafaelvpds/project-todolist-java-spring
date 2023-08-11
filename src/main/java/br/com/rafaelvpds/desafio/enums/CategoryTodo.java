package br.com.rafaelvpds.desafio.enums;

public enum CategoryTodo {
    WORK("Trabalho"), STUDY("Estudo"), PERSONAL("Pessoal");

    private String value;

    private CategoryTodo(String value) {
        this.value = value;
    }

    public String getCategoryTodo() {
        return value;
    }

    @Override
    public String toString() {
        return value;
    }

}

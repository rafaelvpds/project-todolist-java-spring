package br.com.rafaelvpds.desafio.enums;

public enum StatusTodo {
    STOPED("Parado"), PROGRESS("Em andamento"), FINISHED("Concluido");

    private String codeStatus;

    private StatusTodo(String codeStatus) {
        this.codeStatus = codeStatus;
    }

    public String getCodeStatus() {
        return codeStatus;
    }

    @Override

    public String toString() {
        return codeStatus;
    }

}

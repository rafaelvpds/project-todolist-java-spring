package br.com.rafaelvpds.desafio.enums;

public enum StatusTodos {
    WORK(0), STUDY(1), PERSONAL(2);

    private int code;

    private StatusTodos(int code) {
        this.code = code;
    }

    public int getCode() {
        return this.code;
    }

    public static StatusTodos valueOf(int code) {
        for (StatusTodos value : StatusTodos.values()) {
            if (value.getCode() == code) {
                return value;
            }
        }
        throw new IllegalArgumentException("Invalid Status Todo");
    }

}

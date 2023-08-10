package br.com.rafaelvpds.desafio.enums;

public enum CategoryTodo {
    WORK(1), STUDY(2), PERSONAL(3);

    private int code;

    private CategoryTodo(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }

    public static CategoryTodo valueOf(int code) {
        for (CategoryTodo value : CategoryTodo.values()) {
            if (value.getCode() == code) {
                return value;
            }
        }
        throw new IllegalArgumentException("Invalid Status Todo");
    }

}

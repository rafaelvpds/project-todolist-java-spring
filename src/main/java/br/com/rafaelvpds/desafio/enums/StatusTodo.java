package br.com.rafaelvpds.desafio.enums;

public enum StatusTodo {
    STOPED(0), INPROGRESS(2), FINISHED(3);

    private int codeStatus;

    private StatusTodo(int codeStatus) {
        this.codeStatus = codeStatus;
    }

    public int getCodeStatus() {
        return codeStatus;
    }

    public static StatusTodo valeOfStatus(int codeStatus) {
        for (StatusTodo valueStatus : StatusTodo.values()) {
            if (valueStatus.getCodeStatus() == codeStatus) {
                return valueStatus;
            }

        }
        throw new IllegalArgumentException("Invalid Status todos");
    }
}

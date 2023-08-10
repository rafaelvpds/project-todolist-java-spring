package br.com.rafaelvpds.desafio.exeption;

public class RecordNotFaundExeption extends RuntimeException {
    public RecordNotFaundExeption(Long id) {
        super("Record NotFound with id: " + id);
    }
}

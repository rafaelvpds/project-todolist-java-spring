package br.com.rafaelvpds.desafio.enums.converters;

import java.util.stream.Stream;

import br.com.rafaelvpds.desafio.enums.StatusTodo;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter(autoApply = true)
public class StatusTodoConverter implements AttributeConverter<StatusTodo, String> {

    @Override
    public String convertToDatabaseColumn(StatusTodo statusTodo) {

        if (statusTodo == null) {
            return null;
        }
        return statusTodo.getCodeStatus();
    }

    @Override
    public StatusTodo convertToEntityAttribute(String value) {
        if (value == null) {
            return null;
        }
        return Stream.of(StatusTodo.values())
                .filter(s -> s.getCodeStatus().equals(value))
                .findFirst()
                .orElseThrow(IllegalArgumentException::new);

    }

}

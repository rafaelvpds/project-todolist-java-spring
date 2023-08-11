package br.com.rafaelvpds.desafio.enums.converters;

import java.util.stream.Stream;

import br.com.rafaelvpds.desafio.enums.CategoryTodo;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter(autoApply = true)
public class CategoryConverter implements AttributeConverter<CategoryTodo, String> {

    @Override
    public String convertToDatabaseColumn(CategoryTodo category) {

        if (category == null) {
            return null;
        }
        return category.getCategoryTodo();

    }

    @Override
    public CategoryTodo convertToEntityAttribute(String value) {
        if (value == null) {
            return null;
        }

        return Stream.of(CategoryTodo.values())
                .filter(c -> c.getCategoryTodo().equals(value))
                .findFirst()
                .orElseThrow(IllegalArgumentException::new);
    }

}

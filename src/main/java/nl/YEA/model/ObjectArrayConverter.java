package nl.YEA.model;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Converter
public class ObjectArrayConverter implements AttributeConverter<List<Integer>, String> {

    @Override
    public String convertToDatabaseColumn(List<Integer> integers) {
        return integers.stream().map(String::valueOf).collect(Collectors.joining(","));
    }

    @Override
    public List<Integer> convertToEntityAttribute(String s) {
        return Arrays.stream(s.split(",")).map(Integer::valueOf).collect(Collectors.toList());
    }
}

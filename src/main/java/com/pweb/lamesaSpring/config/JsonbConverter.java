package com.pweb.lamesaSpring.config;

import java.util.List;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.pweb.lamesaSpring.model.Produto;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter(autoApply = false)
public class JsonbConverter implements AttributeConverter<List<Produto>, String> {

    private static final ObjectMapper mapper = new ObjectMapper();

    @Override
    public String convertToDatabaseColumn(List<Produto> attribute) {
        try {
            return mapper.writeValueAsString(attribute);
        } catch (Exception e) {
            throw new RuntimeException("Erro ao converter lista para JSON", e);
        }
    }

    @Override
    public List<Produto> convertToEntityAttribute(String dbData) {
        try {
            return mapper.readValue(
                dbData,
                new TypeReference<List<Produto>>() {}
            );
        } catch (Exception e) {
            throw new RuntimeException("Erro ao converter JSON para lista", e);
        }
    }
}

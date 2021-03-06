package lv.javaguru.java3OnlineBanking.core.commons;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;

public interface JsonMapper {

    String mapToString(Object o);

    <T> T mapToObject(String s, Class<T> tClass);
}

@Component
class JsonMapperImpl implements JsonMapper {

    @Autowired
    private ObjectMapper objectMapper;

    @Override
    public String mapToString(Object object) {
        try {
            objectMapper.registerModule(new JavaTimeModule());
            objectMapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
            return objectMapper.writeValueAsString(object);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public <T> T mapToObject(String s, Class<T> tClass) {
        try {
            return objectMapper.readValue(s, tClass);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
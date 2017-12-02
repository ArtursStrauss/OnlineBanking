package lv.javaguru.java3OnlineBanking.app.common;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public interface JsonMapper {

    String mapToString(Object o);

    <T> T mapToObject(String s, Class<T> tClass);

    <T> List<T> mapToObjectList(String s, Class<T[]> tClass);

}

@Component
class JsonMapperImpl implements JsonMapper {

    @Autowired
    private ObjectMapper objectMapper;


    @Override
    public String mapToString(Object object) {
        try {
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

    @Override
    public <T> List<T> mapToObjectList(String s, Class<T[]> tClass) {
        try {
            Class<T[]> arrayClass = (Class<T[]>) Class.forName(tClass.getName());

            T[] objects = objectMapper.readValue(s, arrayClass);

            return Arrays.asList(objects);

        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

}

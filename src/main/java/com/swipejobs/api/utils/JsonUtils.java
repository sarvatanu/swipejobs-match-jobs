package com.swipejobs.api.utils;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class JsonUtils {

    protected <T> List<T>  getFileContents(String fileName, Class<T> valueType) {

        ClassLoader classLoader = getClass().getClassLoader();
        InputStream result = classLoader.getResourceAsStream("schema/"+fileName);

        return covertStringToObject(result, valueType);
    }

    private static <T> List<T> covertStringToObject(InputStream jsonInput, Class<T> valueType) {
        ObjectMapper mapper = new ObjectMapper();
        List<T> mappedOjbject = null;
        try {
            mappedOjbject = mapper.readValue(jsonInput, mapper.getTypeFactory().constructCollectionType(List.class, valueType));

        } catch (IOException e) {
            e.printStackTrace();
        }
        return mappedOjbject;
    }

}

package com.nofacebox.viewshow.Utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class NativeQueryConverter {
    private final static ObjectMapper objectMapper = new ObjectMapper();
    public NativeQueryConverter(){
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
    }

    public static <T> List<T> convert(List<Map<String, Object>> dataList, Class<T> objClass) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        objectMapper.setDateFormat(sdf);
        List<T> res = new ArrayList<>();
        for (Map<String, Object> item: dataList) {
            try {
                String json = objectMapper.writeValueAsString(item);
                T bean = objectMapper.readValue(json, objClass);
                res.add(bean);
            } catch (JsonProcessingException e){
                e.printStackTrace();
            }
        }
        return res;
    }
}

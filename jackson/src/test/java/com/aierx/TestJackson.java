package com.aierx;

import com.aierx.model.po.Person;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.junit.Test;

import java.io.IOException;
import java.util.Date;

public class TestJackson {
    @Test
    public void testJack() throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        Person person = new Person();
        person.setName("Tom");
        person.setAge(40);
        person.setDate(new Date());
        //在反序列化时忽略在 json 中存在但 Java 对象不存在的属性
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES,
                false);
        //在序列化时日期格式默认为 yyyy-MM-dd'T'HH:mm:ss.SSSZ
        mapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);
        //在序列化时忽略值为 null 的属性
        mapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
        //忽略值为默认值的属性
        mapper.setDefaultPropertyInclusion(JsonInclude.Include.NON_DEFAULT);
        String jsonString = mapper.writer()
                .writeValueAsString(person);
        System.out.println(jsonString);
        String aa = "{\"name\":\"Tom\",\"age\":40,\"password\": \"aaaa\"}";
        Person deserializedPerson = mapper.readValue(aa, Person.class);

        System.out.println("aaaaaa");
    }
}

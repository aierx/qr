package com.aierx.model.po;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.Date;

@Data
public class Person {
    @JsonProperty("_name")
    private String name;
    private int age;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date date;
    private String password;

    private String favorite = "leiwen";

}

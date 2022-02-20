package com.aierx.jsr303.util;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Result {

    private Boolean flag;

    private String message;

    private Object data;

    public static Result makeFail(String message){
        return new Result(Boolean.FALSE, message);
    }

    public static Result makeFail(String message,Object data){
        return new Result(Boolean.FALSE, message,data);
    }

    public static Result makeSuccess(String message,Object data){
        return new Result(Boolean.TRUE, message,data);
    }

    public Result(Boolean flag, String message) {
        this.flag = flag;
        this.message = message;
    }
}
package com.aierx.jsr107.model.common;

public class Result {

    public int code;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public static Result makeSuccess(){
        Result result = new Result();
        result.setCode(200);
        return result;
    }
}

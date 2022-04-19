package com.aierx.boot;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;

public class MyException1 implements ExceptionMapper {
    @Override
    public Response toResponse(Throwable throwable) {
        return Response.noContent().build();
    }
}

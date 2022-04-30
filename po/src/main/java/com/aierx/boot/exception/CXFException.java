package com.aierx.boot.exception;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;

/**
 * @author leiwenyong
 * @since 2022/4/17
 */
public class CXFException implements ExceptionMapper {
    @Override
    public Response toResponse(Throwable throwable) {
        return Response.noContent().build();
    }
}

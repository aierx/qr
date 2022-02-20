package com.aierx.boot.exception;

import com.aierx.boot.common.Result;
import org.apache.cxf.jaxrs.utils.JAXRSUtils;

import javax.validation.ValidationException;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;
import javax.ws.rs.core.Response.ResponseBuilder;

@Provider
public class ValidationExceptionMapper implements ExceptionMapper<ValidationException> {

    @Override
    public Response toResponse(ValidationException exception) {
        ResponseBuilder rb = JAXRSUtils.toResponseBuilder(200);
        rb.type("application/json").entity(Result.makeFail(exception.getMessage()));
        return rb.build();
    }
}

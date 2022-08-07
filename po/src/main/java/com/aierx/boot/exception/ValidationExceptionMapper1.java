package com.aierx.boot.exception;

import com.aierx.boot.common.Result;
import org.apache.cxf.jaxrs.utils.JAXRSUtils;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.ResponseBuilder;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

/**
 * @author aleiwe
 */
@Provider
public class ValidationExceptionMapper1 implements ExceptionMapper<WebApplicationException> {

    @Override
    public Response toResponse(WebApplicationException exception) {
        ResponseBuilder rb = JAXRSUtils.toResponseBuilder(200);
        rb.type("application/json").entity(Result.makeFail(exception.getMessage()));
        return rb.build();
    }
}

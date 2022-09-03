package icu.aierx.po.exception;

import icu.aierx.po.common.Result;
import org.apache.cxf.jaxrs.utils.JAXRSUtils;

import javax.validation.ValidationException;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.ResponseBuilder;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

/**
 * @author aleiwe
 */
@Provider
public class ValidationExceptionMapper implements ExceptionMapper<ValidationException> {

    @Override
    public Response toResponse(ValidationException exception) {
        ResponseBuilder rb = JAXRSUtils.toResponseBuilder(200);
        rb.type("application/json").entity(Result.makeFail(exception.getMessage()));
        return rb.build();
    }
}

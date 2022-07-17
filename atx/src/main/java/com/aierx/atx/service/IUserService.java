package com.aierx.atx.service;

import com.aierx.atx.model.User;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

/**
 * @author leiwenyong
 * @since 2022-07-12
 */
@Path("/user")
@Produces("application/json")
@Consumes("application/json")
public interface IUserService {

    @GET
    @Path("find")
    User getUser();
}

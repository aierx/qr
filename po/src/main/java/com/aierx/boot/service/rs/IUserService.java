package com.aierx.boot.service.rs;

import com.aierx.boot.model.po.UserPO;

import javax.validation.Valid;
import javax.ws.rs.*;

@Produces("application/json")
@Consumes("application/json")
@Path("/serere")
public interface IUserService {
    @GET()
    @Path("/user")
    UserPO getUser(@QueryParam("id")int id);

    @POST
    @Path("/user")
    UserPO updateUser(@Valid UserPO userPO);
}

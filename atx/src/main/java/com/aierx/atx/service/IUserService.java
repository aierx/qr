package com.aierx.atx.service;

import com.aierx.atx.model.po.UserPO;

import javax.ws.rs.*;

@Produces("application/json")
@Consumes("application/json")
public interface IUserService {
    @GET()
    @Path("/user")
    UserPO getUser();

    @POST
    @Path("/user")
    UserPO updateUser(UserPO userPO);
}

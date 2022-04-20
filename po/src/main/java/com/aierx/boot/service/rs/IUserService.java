package com.aierx.boot.service.rs;

import com.aierx.boot.model.po.UserPO;

import javax.validation.Valid;
import javax.ws.rs.*;
import java.util.List;

@Produces("application/json")
@Consumes("application/json")
@Path("/serere")
public interface IUserService {
    @GET()
    @Path("/user")
    List<UserPO> getUser(@QueryParam("id")String id);

    @POST
    @Path("/user")
    UserPO updateUser(@Valid UserPO userPO);

    @POST
    @Path("/update")
    int UpdateUser(UserPO userPO) throws Exception;

    @POST
    @Path("/dalete")
    int deleteUser(UserPO userPO);

    @POST
    @Path("/insert")
    int insertUser(UserPO userPO);

    void otherFun4(UserPO userPO);
}

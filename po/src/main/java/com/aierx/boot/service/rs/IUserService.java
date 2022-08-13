package com.aierx.boot.service.rs;

import com.aierx.boot.model.po.CC;
import com.aierx.boot.model.po.UserPO;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.ws.rs.*;
import java.util.List;

@Produces("application/json")
@Consumes("application/json")
public interface IUserService {
    
    @GET()
    @Path("/user")
    List<UserPO> getUser(@QueryParam("id") @NotNull String id) throws InterruptedException;

    @POST
    @Path("/user")
    UserPO updateUser(@Valid UserPO userPO);

    @POST
    @Path("/update")
    int UpdateUser(CC cc) throws Exception;

    @POST
    @Path("/dalete")
    int deleteUser(UserPO userPO);

    @POST
    @Path("/insert")
    int insertUser(UserPO userPO);

    void otherFun4(UserPO userPO);
}

package com.aierx.boot.service.rs;

import com.aierx.boot.model.po.UserPO;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotBlank;
import javax.ws.rs.*;
import java.util.List;

@Produces("application/json")
@Consumes("application/json")
@Validated
public interface IUserService {
	
	@POST()
	@Path("/user")
	List<UserPO> getUser(@QueryParam("id") @NotBlank(message = "不能为空")  String id, @Validated({FunctionalInterface.class}) UserPO userPO) throws InterruptedException;

//    @POST
//    @Path("/user")
//    UserPO updateUser(@Valid UserPO userPO);

//    @POST
//    @Path("/update")
//    int UpdateUser(CC cc) throws Exception;
//
//    @POST
//    @Path("/dalete")
//    int deleteUser(UserPO userPO);
//
//    @POST
//    @Path("/insert")
//    int insertUser(UserPO userPO);
//
//    void otherFun4(UserPO userPO);
}

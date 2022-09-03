package com.aierx.boot.service.rs;

import com.aierx.boot.model.po.UserPO;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import java.util.List;

@Produces("application/json")
@Consumes("application/json")
public interface IUserService {
	
	@POST()
	@Path("/user")
	List<UserPO> getUser(String id, UserPO userPO) throws InterruptedException;

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

package org.example.service.rs;


import org.example.model.User;

import javax.ws.rs.*;

@Path("/user")
@Produces("application/json")
@Consumes("application/json")
public interface IUserService {
    @GET
    @Path("/{id}")
    public User getUserById(@PathParam("id")int id) ;
}

package com.example.service;


import javax.annotation.ManagedBean;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

/**
 * @author leiwenyong
 * @since 2022-05-15
 */
@ManagedBean
@Path("/managedbean")
public class UserService {

    @GET
    @Produces("text/plain")
    public String getIt() {
        return "Hi managed bean!";
    }

}

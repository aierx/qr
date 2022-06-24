package com.example;

import com.example.entity.User;
import com.example.service.LocalEjb;
import com.example.service.UserService;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 * Root resource (exposed at "myresource" path)
 */
@Path("myresource")
public class MyResource {

    @Inject
    UserService userService;

    @Inject
    LocalEjb localEjb;

    /**
     * Method handling HTTP GET requests. The returned object will be sent
     * to the client as "text/plain" media type.
     *
     * @return String that will be returned as a text/plain response.
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public User getIt() {
        User user = new User(userService.getIt(), userService.getIt());
        return user;
    }

    @GET()
    @Path("local")
    @Produces(MediaType.APPLICATION_JSON)
    public User getLocal() {
        User user = new User(localEjb.getIt(), localEjb.getIt());
        return user;
    }
}

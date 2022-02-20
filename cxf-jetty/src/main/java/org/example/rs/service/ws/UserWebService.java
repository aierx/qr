package org.example.rs.service.ws;

import org.example.rs.model.User;

import javax.jws.WebService;

@WebService(serviceName = "user",endpointInterface = "org.example.rs.service.ws.IUserWebService")
public class UserWebService implements IUserWebService{
    @Override
    public User getUser(int id) {
        System.out.println(id);
        return new User("leiwenyong","12321321313");
    }
}

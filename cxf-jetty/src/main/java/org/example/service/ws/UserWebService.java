package org.example.service.ws;

import org.example.model.User;

import javax.jws.WebService;

@WebService(serviceName = "user",endpointInterface = "org.example.service.ws.IUserWebService")
public class UserWebService implements IUserWebService{
    @Override
    public User getUser(int id) {
        System.out.println(id);
        return new User("leiwenyong","12321321313");
    }
}

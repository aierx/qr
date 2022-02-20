package org.example.rs.service.ws;

import org.example.rs.model.User;

import javax.jws.WebMethod;
import javax.jws.WebService;

@WebService
public interface IUserWebService {

    @WebMethod
    public User getUser(int id);
}

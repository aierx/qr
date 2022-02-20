package org.example.service.ws;

import org.example.model.User;

import javax.jws.WebMethod;
import javax.jws.WebService;

@WebService
public interface IUserWebService {

    @WebMethod
    public User getUser(int id);
}

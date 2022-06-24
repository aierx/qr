package com.example.service;

import javax.ejb.Stateless;
import javax.ws.rs.Path;

@Stateless
@Path("/stateless")
public class StatelessEjbResource implements LocalEjb {
    @Override
    public String getIt() {
        return "Hi Stateless!";
    }
}


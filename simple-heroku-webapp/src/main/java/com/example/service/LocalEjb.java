package com.example.service;

import javax.ejb.Local;
import javax.ws.rs.GET;
import javax.ws.rs.Produces;

@Local
public interface LocalEjb {
    @GET
    @Produces("text/plain")
    public String getIt();
}

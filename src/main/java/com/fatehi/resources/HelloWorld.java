package com.fatehi.resources;


import com.fatehi.models.User;
import io.dropwizard.auth.Auth;
import jakarta.annotation.security.DenyAll;
import jakarta.annotation.security.RolesAllowed;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;

@Path("/test")
public class HelloWorld {



    @RolesAllowed("ADMIN")
    @GET
    public String test(@Auth User user) {
        return "hello world";
    }

}

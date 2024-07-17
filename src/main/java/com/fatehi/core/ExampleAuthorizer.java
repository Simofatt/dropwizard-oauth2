package com.fatehi.core;

import com.fatehi.models.User;
import io.dropwizard.auth.Authorizer;
import jakarta.ws.rs.container.ContainerRequestContext;
import org.checkerframework.checker.nullness.qual.Nullable;

public class ExampleAuthorizer implements Authorizer<User> {
    @Override
    public boolean authorize(User user, String role, @Nullable ContainerRequestContext containerRequestContext) {
        return user.getUsername().equals("good") && role.equals("ADMIN");
    }


}
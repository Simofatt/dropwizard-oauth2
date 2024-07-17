package com.fatehi.core;

import com.fatehi.models.OAuth2Token;
import com.fatehi.models.User;
import io.dropwizard.auth.Authenticator;
import java.util.Optional;

    public class OAuth2Authenticator implements Authenticator<String, User> {
        @Override
        public Optional<User> authenticate(String token) {
            // Verify the token here and return an Optional<User>
            // This could involve calling an OAuth2 provider's introspection endpoint or verifying JWT locally
            if (isValidToken(token)) {
                // Assuming you have a method to extract the user info from the token
                return Optional.of(new User("username_from_token"));
            }
            return Optional.empty();
        }

        private boolean isValidToken(String token) {
            // Implement your token validation logic here
            return true; // Placeholder for actual validation
        }
    }


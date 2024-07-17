package com.fatehi;

import com.fatehi.core.ExampleAuthenticator;
import com.fatehi.core.ExampleAuthorizer;
import com.fatehi.core.OAuth2Authenticator;
import com.fatehi.models.User;
import com.fatehi.resources.HelloWorld;
import io.dropwizard.auth.AuthDynamicFeature;
import io.dropwizard.auth.AuthValueFactoryProvider;
import io.dropwizard.auth.basic.BasicCredentialAuthFilter;
import io.dropwizard.auth.oauth.OAuthCredentialAuthFilter;
import io.dropwizard.core.Application;
import io.dropwizard.core.setup.Bootstrap;
import io.dropwizard.core.setup.Environment;
import org.glassfish.jersey.server.filter.RolesAllowedDynamicFeature;

public class OauthServiceApplication extends Application<OauthServiceConfiguration> {

    public static void main(final String[] args) throws Exception {
        new OauthServiceApplication().run(args);
    }

    @Override
    public String getName() {
        return "OauthService";
    }

    @Override
    public void initialize(final Bootstrap<OauthServiceConfiguration> bootstrap) {
        // TODO: application initialization
    }

    @Override
    public void run(final OauthServiceConfiguration configuration,
                    final Environment environment) {
//  THIS IS FOR TOKEN OAUTH2
//        environment.jersey().register(new OAuthCredentialAuthFilter.Builder<User>()
//                .setAuthenticator(new OAuth2Authenticator())
//                .setAuthorizer(new ExampleAuthorizer())
//                .setPrefix("Basic")
//                .buildAuthFilter());


        environment.jersey().register(new AuthDynamicFeature(
                new BasicCredentialAuthFilter.Builder<User>()
                        .setAuthenticator(new ExampleAuthenticator())
                        .setAuthorizer(new ExampleAuthorizer())
                        .setRealm("SUPER SECRET STUFF")
                        .buildAuthFilter()));

        environment.jersey().register(RolesAllowedDynamicFeature.class);

        //If you want to use @Auth to inject a custom Principal type into your resource
        environment.jersey().register(new AuthValueFactoryProvider.Binder<>(User.class));
        environment.jersey().register(HelloWorld.class);

    }

}

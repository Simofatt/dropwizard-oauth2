package com.fatehi;

import io.dropwizard.core.Application;
import io.dropwizard.core.setup.Bootstrap;
import io.dropwizard.core.setup.Environment;

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
        // TODO: implement application
    }

}

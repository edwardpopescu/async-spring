package com.inghubs.asyncspring.config.jersey;

import com.inghubs.asyncspring.controller.jersey.HelloJerseyController;
import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.servlet.ServletProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
public class JerseyConfiguration extends ResourceConfig {
    public JerseyConfiguration() {
        register(HelloJerseyController.class);
        property(ServletProperties.FILTER_FORWARD_ON_404, true);
    }
}

package com.momentum.backend;


import com.momentum.backend.controllers.InvestorsController;
import com.momentum.backend.controllers.ProductController;
import jakarta.ws.rs.ApplicationPath;
import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.server.ServerProperties;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ApplicationPath("/momentum")
@ComponentScan(basePackages = {"com.momentum.backend.controllers"})
public class JerseyConfig extends ResourceConfig {
    public JerseyConfig() {
        property(ServerProperties.BV_SEND_ERROR_IN_RESPONSE, true);
        property(ServerProperties.BV_DISABLE_VALIDATE_ON_EXECUTABLE_OVERRIDE_CHECK, true);
        register(RuntimeException.class);
        register(InvestorsController.class);
        register(ProductController.class);

    }
}

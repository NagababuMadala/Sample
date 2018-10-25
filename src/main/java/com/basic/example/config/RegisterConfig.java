package com.basic.example.config;

import io.swagger.jaxrs.config.BeanConfig;
import io.swagger.jaxrs.config.SwaggerConfigLocator;
import io.swagger.jaxrs.config.SwaggerContextService;
import io.swagger.jaxrs.listing.ApiListingResource;
import org.glassfish.jersey.server.ResourceConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.ws.rs.ApplicationPath;

import static com.basic.example.util.EmployeeConstants.*;

@Component
@ApplicationPath(APPLICATION_PATH)
public class RegisterConfig extends ResourceConfig {
    private static Logger logger = LoggerFactory.getLogger(RegisterConfig.class);

    @Value("${host}")
    private String host;

    @Value("${server.servlet.context-path}")
    private String servletContextPath;


    public RegisterConfig() {
        logger.debug("Resources Registered");
        packages(RESOURCES_PACKAGE);
    }

    @PostConstruct
    public void init() {
        logger.debug("Swagger Configuration Completed");
        BeanConfig swaggerConfig = new BeanConfig();
        swaggerConfig.setBasePath(servletContextPath + APPLICATION_PATH);
        swaggerConfig.setHost(this.host);
        swaggerConfig.setTitle(EMPLOYEE_MANAGEMENT);
        SwaggerConfigLocator.getInstance().putConfig(SwaggerContextService.CONFIG_ID_DEFAULT, swaggerConfig);
        packages(getClass().getPackage().getName(), ApiListingResource.class.getPackage().getName());
    }
}
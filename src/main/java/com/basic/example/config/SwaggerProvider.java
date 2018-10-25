package com.basic.example.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;
import springfox.documentation.swagger.web.InMemorySwaggerResourcesProvider;
import springfox.documentation.swagger.web.SwaggerResource;
import springfox.documentation.swagger.web.SwaggerResourcesProvider;

import javax.annotation.Resource;
import java.util.List;
import java.util.stream.Collectors;
import static com.basic.example.util.EmployeeConstants.*;

    @Component
    @Primary
    public class SwaggerProvider implements SwaggerResourcesProvider {

        private static final Logger logger = LoggerFactory.getLogger(RegisterConfig.class);

        @Resource
        private InMemorySwaggerResourcesProvider inMemorySwaggerResourcesProvider;

        public List<SwaggerResource> get() {
            logger.debug("Swagger Created");
            SwaggerResource swaggerResource = new SwaggerResource();
            swaggerResource.setLocation(SWAGGER_JSON_LOCATION);
            swaggerResource.setSwaggerVersion(SWAGGER_VERSION);
            swaggerResource.setName(JAX_RS);

            return java.util.stream.Stream.concat(java.util.stream.Stream.of(swaggerResource),
                    inMemorySwaggerResourcesProvider.get().stream()).collect(Collectors.toList());
        }
    }

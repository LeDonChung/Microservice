package vn.iuh.edu.fit.apigateway.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class GatewayConfig {

    @Bean
    public RouteLocator routes(RouteLocatorBuilder builder) {
        return builder.routes()
                .route("product-mc-service", r -> r.path("/api/v1/product/**")
                        .uri("lb://product-mc-service"))
                .route("customer-mc-service", r -> r.path("/api/v1/customer/**")
                        .uri("lb://customer-mc-service"))
                .route("order-mc-service", r -> r.path("/api/v1/order/**")
                        .uri("lb://order-mc-service"))
                .build();
    }
}
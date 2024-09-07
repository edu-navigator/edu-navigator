package org.edunavigator.gateway.routes;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.gateway.server.mvc.handler.GatewayRouterFunctions;
import org.springframework.cloud.gateway.server.mvc.handler.HandlerFunctions;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.function.RequestPredicates;
import org.springframework.web.servlet.function.RouterFunction;
import org.springframework.web.servlet.function.ServerResponse;
@Configuration
public class RoutesConfig {
    //urls
    @Value("${services.ingestion.host}")
    private String ingestionServiceHost;
    @Value("${services.search.host}")
    private String searchServiceHost;
    @Value("${services.content.host}")
    private String contentServiceHost;
    @Value("${services.auth.host}")
    private String authServiceHost;
    //paths
    @Value("${services.ingestion.path}")
    private String ingestionPath;
    @Value("${services.search.path}")
    private String searchPath;
    @Value("${services.content.path}")
    private String contentPath;
    @Value("${services.auth.path}")
    private String authPath;
    @Bean
    public RouterFunction<ServerResponse> ingestionServiceRoute(){
        return GatewayRouterFunctions.route("ingestion_service")
                .route(RequestPredicates.path(ingestionPath), HandlerFunctions.http(ingestionServiceHost))
                .build();
    }
    @Bean
    public RouterFunction<ServerResponse> searchServiceRoute(){
        return GatewayRouterFunctions.route("search_service")
                .route(RequestPredicates.path(searchPath), HandlerFunctions.http(searchServiceHost))
                .build();
    }
    @Bean
    public RouterFunction<ServerResponse> contentServiceRoute(){
        return GatewayRouterFunctions.route("content_service")
                .route(RequestPredicates.path(contentPath), HandlerFunctions.http(contentServiceHost))
                .build();
    }
    @Bean
    public RouterFunction<ServerResponse> authenticationServiceRoute(){
        return GatewayRouterFunctions.route("authentication_service")
                .route(RequestPredicates.path(authPath), HandlerFunctions.http(authServiceHost))
                .build();
    }
}

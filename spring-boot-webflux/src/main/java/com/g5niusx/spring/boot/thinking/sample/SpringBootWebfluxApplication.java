package com.g5niusx.spring.boot.thinking.sample;

import com.g5niusx.spring.boot.thinking.sample.controller.AppHandler;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.context.WebServerInitializedEvent;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.event.EventListener;
import org.springframework.web.reactive.config.EnableWebFlux;
import org.springframework.web.reactive.function.server.RequestPredicates;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

@SpringBootApplication
@Slf4j
@EnableWebFlux
public class SpringBootWebfluxApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootWebfluxApplication.class, args);
    }

    @EventListener(WebServerInitializedEvent.class)
    public void event(WebServerInitializedEvent webServerInitializedEvent) {
        log.info("加载的 webServer 为:{}", webServerInitializedEvent);
    }

    @Configuration
    static class WebFluxConfiguration {

        @Bean
        public RouterFunction<ServerResponse> appRouter(AppHandler appHandler) {
            // pattern 要使用 / 开头，否则访问的时候会报找不到地址
            return RouterFunctions.route(RequestPredicates.GET("/webflux/appInfo"), request -> appHandler.app());
        }
    }
}

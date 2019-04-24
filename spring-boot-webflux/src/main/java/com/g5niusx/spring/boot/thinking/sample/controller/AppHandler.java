package com.g5niusx.spring.boot.thinking.sample.controller;

import com.g5niusx.spring.boot.thinking.sample.properties.AppProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

@Component
public class AppHandler {

    @Autowired
    private AppProperties appProperties;

    public Mono<ServerResponse> app() {
        return ServerResponse.ok().body(BodyInserters.fromObject(appProperties));
    }
}

package com.g5niusx.spring.boot.thinking.sample.controller;

import com.g5niusx.spring.boot.thinking.sample.properties.AppProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 在 webflux 中兼容了 spring mvc 的写法，支持 mvc 中的 RestController 等注解
 *
 * @author g5niusx
 */
@RestController
public class WebfluxController {
    @Autowired
    private AppProperties appProperties;

    @GetMapping(value = "/restInfo")
    public ResponseEntity<AppProperties> appInfo() {
        return ResponseEntity.ok(appProperties);
    }
}

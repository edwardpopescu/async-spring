package com.inghubs.asyncspring.controller.webflux;

import com.inghubs.asyncspring.model.User;
import com.inghubs.asyncspring.service.UserRetrievalService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("hello")
@RequiredArgsConstructor
public class HelloWebFluxController {

    private final UserRetrievalService userRetrievalService;

    @GetMapping("webflux")
    public Mono<User> greeting() {
        return userRetrievalService.retrieveUser("Webflux");
    }
}

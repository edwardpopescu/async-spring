package com.inghubs.asyncspring.controller.mvc;

import com.inghubs.asyncspring.model.User;
import com.inghubs.asyncspring.service.UserRetrievalService;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Async;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.CompletableFuture;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequiredArgsConstructor
@RequestMapping("hello/mvc")
public class HelloMvcController {

    private final UserRetrievalService userRetrievalService;

    @GetMapping(value = "/",  produces = APPLICATION_JSON_VALUE)
    public User greeting() {
        return userRetrievalService.retrieveUser("MVC");
    }

    @GetMapping(value = "async",  produces = APPLICATION_JSON_VALUE)
    @Async("asyncExecutor")
    public CompletableFuture<User> asyncGreeting() {
        return CompletableFuture.supplyAsync(() -> userRetrievalService.retrieveUser("MVC"));
    }

}

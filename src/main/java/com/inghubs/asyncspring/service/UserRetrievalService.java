package com.inghubs.asyncspring.service;

import com.inghubs.asyncspring.model.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;


@Service
@Slf4j
public class UserRetrievalService {

    private final WebClient client = WebClient.create("http://localhost:8080/hello/wiremock");

    public Mono<User> retrieveUser() {
        return client.get()
                .retrieve()
                .bodyToMono(User.class);
    }

}

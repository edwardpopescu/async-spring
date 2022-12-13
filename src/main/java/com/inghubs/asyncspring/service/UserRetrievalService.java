package com.inghubs.asyncspring.service;

import com.inghubs.asyncspring.model.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.util.concurrent.CompletableFuture;


@Service
@Slf4j
public class UserRetrievalService {

    public Mono<User> retrieveUser(String source) {
        CompletableFuture<User> futureUser = CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(50L);
            } catch (InterruptedException e) {
                log.error("Exception during thread sleep", e);
                throw new RuntimeException(e);
            }
            return new User(source + " user");
        });
        return Mono.fromFuture(futureUser);
    }

}

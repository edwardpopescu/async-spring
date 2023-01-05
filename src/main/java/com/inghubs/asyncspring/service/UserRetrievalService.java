package com.inghubs.asyncspring.service;

import com.inghubs.asyncspring.model.User;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.ListenableFutureCallback;
import org.springframework.web.client.AsyncRestTemplate;
import org.springframework.web.client.RestTemplate;

import java.util.concurrent.CompletableFuture;


@Service
public class UserRetrievalService {

    private final RestTemplate restTemplate = new RestTemplate();

    private final AsyncRestTemplate asyncRestTemplate = new AsyncRestTemplate();

    public User retrieveUser() {
        return restTemplate.getForObject("http://localhost:8080/hello/wiremock", User.class);
    }

    public CompletableFuture<User> retrieveUserAsync() {
        return toCompletableFuture(asyncRestTemplate.getForEntity("http://localhost:8080/hello/wiremock", User.class));
    }

    public CompletableFuture<User> toCompletableFuture(ListenableFuture<ResponseEntity<User>> listenableFuture) {
        final CompletableFuture<User> completableFuture = new CompletableFuture<>();
        listenableFuture.addCallback(new ListenableFutureCallback<>() {
            @Override
            public void onFailure(Throwable e) {
                completableFuture.completeExceptionally(e);
            }

            @Override
            public void onSuccess(ResponseEntity<User> result) {
                completableFuture.complete(result.getBody());
            }
        });
        return completableFuture;
    }

}

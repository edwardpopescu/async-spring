package com.inghubs.asyncspring.service;

import com.inghubs.asyncspring.model.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;


@Service
@Slf4j
public class UserRetrievalService {

    private final Client client = ClientBuilder.newClient();
    private final WebTarget wiremockTarget
            = client.target("http://localhost:8080/hello/wiremock");

    public User retrieveUser() {
        Invocation.Builder invocationBuilder = wiremockTarget.request(MediaType.APPLICATION_JSON);
        return invocationBuilder.get(User.class);
    }

}

package com.inghubs.asyncspring.service;

import com.inghubs.asyncspring.model.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;


@Service
@Slf4j
public class UserRetrievalService {

    public User retrieveUser(String source) {
        try {
            Thread.sleep(50L);
        } catch (InterruptedException e) {
            log.error("Exception during thread sleep", e);
            throw new RuntimeException(e);
        }
        return new User(source + " user");
    }

}

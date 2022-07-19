package com.inghubs.asyncspring.controller.mvc;

import com.inghubs.asyncspring.model.User;
import com.inghubs.asyncspring.service.UserRetrievalService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequiredArgsConstructor
@RequestMapping("hello")
public class HelloMvcController {

    private final UserRetrievalService userRetrievalService;

    @GetMapping(value = "mvc",  produces = APPLICATION_JSON_VALUE)
    public final User greeting() {
        return userRetrievalService.retrieveUser("MVC");
    }

}

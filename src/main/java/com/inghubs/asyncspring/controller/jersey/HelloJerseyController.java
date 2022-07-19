package com.inghubs.asyncspring.controller.jersey;

import com.inghubs.asyncspring.service.UserRetrievalService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import static javax.ws.rs.core.MediaType.APPLICATION_JSON;

@Controller
@RequiredArgsConstructor
@Path("hello")
public class HelloJerseyController {

    private final UserRetrievalService userRetrievalService;

    @GET
    @Path("jersey")
    @Produces(APPLICATION_JSON)
    public final Response greeting() {
        return Response.ok(userRetrievalService.retrieveUser("Jersey")).build();
    }

}

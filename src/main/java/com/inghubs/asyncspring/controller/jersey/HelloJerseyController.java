package com.inghubs.asyncspring.controller.jersey;

import com.inghubs.asyncspring.model.User;
import com.inghubs.asyncspring.service.UserRetrievalService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.container.AsyncResponse;
import javax.ws.rs.container.Suspended;
import javax.ws.rs.core.Response;

import static javax.ws.rs.core.MediaType.APPLICATION_JSON;

@Controller
@RequiredArgsConstructor
@Path("hello/jersey")
public class HelloJerseyController {

    private final UserRetrievalService userRetrievalService;

    @GET
    @Path("/")
    @Produces(APPLICATION_JSON)
    public Response greeting() {
        return Response.ok(userRetrievalService.retrieveUser("Jersey")).build();
    }

    @GET
    @Path("/async")
    @Produces(APPLICATION_JSON)
    public void greetingAsync(@Suspended final AsyncResponse asyncResponse) {
        new Thread(() -> {
            User user = userRetrievalService.retrieveUser("Jersey");
            asyncResponse.resume(user);
        }).start();
    }

}

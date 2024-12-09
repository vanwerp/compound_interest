package com.github.vanwerp.calculator.api.controller;

import com.github.vanwerp.calculator.api.mapper.UserMapper;
import com.github.vanwerp.calculator.api.request.UserRequest;
import com.github.vanwerp.calculator.api.resources.UserResource;
import com.github.vanwerp.calculator.core.services.UserService;
import io.quarkus.security.Authenticated;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.Context;
import jakarta.ws.rs.core.SecurityContext;
import lombok.extern.slf4j.Slf4j;
import org.jboss.resteasy.reactive.RestResponse;

@Slf4j
@Path("/user")
public class UserController {

    @Inject
    private UserService userService;

    @Inject
    private UserMapper userMapper;

    @POST
    public RestResponse<UserResource> saveUser(UserRequest request){
        return RestResponse.ok(userMapper.toResource(userService.saveUser(userMapper.fromRequestToModel(request))));
    }

    @Path("me")
    @GET
    @Authenticated
    public RestResponse<UserResource> getOwnUser(@Context SecurityContext securityContext){
        String username = securityContext.getUserPrincipal().getName();
        return RestResponse.ok(userMapper.toResource(userService.getUserByUsername(username)));
    }

}

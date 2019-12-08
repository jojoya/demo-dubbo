package com.example.userapis.api;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

import com.example.userapis.domain.User;
@Path("user")
public interface UserService {

    @Path("get/{userNo}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    User getUserByUserNo(@PathParam("userNo") Integer userNo);
//    User getUserByUserNo(Integer userNo);
}

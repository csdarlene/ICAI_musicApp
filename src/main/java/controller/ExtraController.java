package controller;

import entity.Users;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import service.UserService;

import jakarta.ws.rs.POST;
import jakarta.ws.rs.core.MediaType;

@Path("extra")
public class ExtraController {
    private final UserService userService = new UserService();
//    @Path("/signin")
//    @POST
//    @Consumes(MediaType.APPLICATION_JSON)
//    @Produces(MediaType.APPLICATION_JSON)
//    public void SignIn(Users users) {
//        userService.signIn(users.getUsername(),users.getPassword());
//    }
}

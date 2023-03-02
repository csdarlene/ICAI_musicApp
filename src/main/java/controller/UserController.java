package controller;

import entity.Users;
import jakarta.ws.rs.*;
import service.UserService;

import jakarta.ws.rs.core.MediaType;
import java.util.List;

@Path("users")
public class UserController {
    private final UserService userService = new UserService();

    @Path("/readUsers")
    @GET
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public String readUsers() {
        return userService.getAllUsers().toString();
    }

    @Path("/{getUser}")
    @GET
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public String getUser(@PathParam("getUser") Long id) {
        return userService.findUser(id).toString();
    }

    @Path("/find/{findUser}")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public String findUser(@PathParam("findUser") Long id) {
        return userService.findUser(id).toString();
    }

    @Path("/getDetailsOfUser")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public void getDetailsOfUser(Users Users) {
        userService.getDetailsOfUsers(Users.getUsername());
    }


    @Path("/createUser")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public void createUser(Users User) {
        userService.createUsers(User);
    }

    @Path("/deleteUser")
    @DELETE
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public void deleteUser(Users User) {
        userService.deleteUser(User.getId());
    }

    @Path("/updatePasswordUser")
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public void updateNameUser(Users User) {
        userService.updateUserPassword(User.getId(), User.getPassword());
    }

    @Path("/updateNameUser")
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public void updateEmailUser(Users User) {
        userService.updateUserUsername(User.getId(), User.getUsername());
    }

  /*  @Path("/signIn")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public boolean SignIn(String username,String password) {
       return userService.signIn(username, password);
    }*/
}

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
    @Produces(MediaType.APPLICATION_JSON)
    public List<Users> readUsers() {
        return userService.getAllUsers();
    }

    @Path("/{getUser}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Users getUser(@PathParam("getUser") Long id) {
        return userService.findUser(id);
    }

    @Path("/find/{findUser}")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Users findUser(@PathParam("findUser") Long id) {
        return userService.findUser(id);
    }


    @Path("/getDetailsOfUser")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public void getDetailsOfUser(Users Users) {
        userService.getDetailsOfUsers(Users.getUsername());
    }


    @Path("/createUser")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public void createUser(Users User) {
        userService.createUsers(User);
    }

    @Path("/deleteUser")
    @DELETE
    public void deleteUser(Users User) {
        userService.deleteUser(User.getId());
    }

    @Path("/updatePasswordUser")
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public void updateNameUser(Users User) {
        userService.updateUserPassword(User.getId(), User.getPassword());
    }

    @Path("/updateNameUser")
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public void updateEmailUser(Users User) {
        userService.updateUserUsername(User.getId(), User.getUsername());
    }

  /*  @Path("/signIn")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public boolean SignIn(String username,String password) {
       return userService.signIn(username, password);
    }*/
}

package controller;

import entity.Users;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import service.UserService;

import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.core.MediaType;

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

    @Path("/getUser")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Users getUser(Users Users) {
        return userService.findUser(Users.getId());
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

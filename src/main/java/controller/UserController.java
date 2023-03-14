package controller;

import entity.Users;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.Response;
import service.UserService;

import jakarta.ws.rs.core.MediaType;

import java.util.List;

@Path("users")
public class UserController {
    private final UserService userService = new UserService();

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

    @Path("/{id}")
    @DELETE
    public Response deleteUser(@PathParam("id") Long id) {
        userService.deleteUser(id);
        return Response.status(Response.Status.OK).build();
    }

    @Path("/DetailsOfUser/{name}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Users> getDetailsOfUser(@PathParam("name") String name) {
        return userService.getDetailsOfUsers(name);
    }

    @Path("/create")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Users createUser(Users User) {
        return userService.createUsers(User);
    }

    @Path("/{id}/password")
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response updateNameUser(@PathParam("id") Long id, String password) {
        userService.updateUserPassword(id, password);
        return Response.status(Response.Status.OK).build();
    }

    @Path("/{id}/username")
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response updateEmailUser(@PathParam("id") Long id, String username) {
        userService.updateUserUsername(id, username);
        return Response.status(Response.Status.OK).build();
    }
    @Path("/{username}/{password}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Boolean updateEmailUser(@PathParam("username")String username,@PathParam("password")String password) {
        return userService.signIn(username, password) != null;
    }
}

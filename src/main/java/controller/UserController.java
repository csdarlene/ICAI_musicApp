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
    public String getDetailsOfUser(@PathParam("name") String name)  {
        return userService.getDetailsOfUsers(name).toString();
   }

    @Path("/createUser")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public void createUser(Users User) {
        userService.createUsers(User);
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

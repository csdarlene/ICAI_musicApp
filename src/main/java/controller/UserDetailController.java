package controller;

import application.InputChecker;
import entity.UserDetails;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.Response;
import service.UserDetailService;

import jakarta.ws.rs.core.MediaType;

import java.util.List;

@Path("userDetails")
public class UserDetailController {
    private final UserDetailService userDetailService = new UserDetailService();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<UserDetails> readUserDetails() {
        return userDetailService.getAllUserDetails();
    }

    @Path("/{id}")
    @DELETE
    public Response deleteUserDetail(@PathParam("id") Long id) {
        userDetailService.deleteUserDetail(id);
        return Response.status(Response.Status.OK).build();
    }

    @Path("/create")
    @POST
    public Response createUserDetail(@FormParam("name") String name,@FormParam("mail") String mail,@FormParam("birthday") String birthday) {
//        InputChecker inputChecker = new InputChecker();
//        if (inputChecker.BirthdayCheck(birthday).equals(birthday)) {
//            if (inputChecker.MailCheck(mail).equals(mail)) {
                userDetailService.createUserDetails(new UserDetails(name, birthday, mail));
                return Response.status(Response.Status.OK).build();
//            }
//        }return Response.status(Response.Status.BAD_REQUEST).build();
    }

    @Path("/{id}/name")
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response updateNameUserDetail(@PathParam("id") Long id, String name) {
        userDetailService.updateUserDetailName(id, name);
        return Response.status(Response.Status.OK).build();
    }

    @Path("/{id}/email")
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response updateEmailUserDetail(@PathParam("id") Long id, String email) {
        userDetailService.updateUserDetailEmail(id, email);
        return Response.status(Response.Status.OK).build();
    }
}

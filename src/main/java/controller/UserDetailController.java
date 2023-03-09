package controller;

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
    @Consumes(MediaType.APPLICATION_JSON)
    public UserDetails createUserDetail(UserDetails userDetail) {
        return userDetailService.createUserDetails(userDetail);
    }


    @Path("/updateNameUserDetail")
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public void updateNameUserDetail(UserDetails userDetail) {
        userDetailService.updateUserDetailName(userDetail.getId(), userDetail.getName());
    }

    @Path("/updateEmailUserDetail")
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public void updateEmailUserDetail(UserDetails userDetail) {
        userDetailService.updateUserDetailName(userDetail.getId(), userDetail.getEmail());
    }
}

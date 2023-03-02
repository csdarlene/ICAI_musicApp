package controller;

import entity.UserDetails;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import service.UserDetailService;

import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.core.MediaType;

@Path("userDetails")
public class UserDetailController{
    private final UserDetailService userDetailService = new UserDetailService();

    @Path("/readUserDetails")
    @GET
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public String readUserDetails(){
        return userDetailService.getAllUserDetails().toString();
    }


    @Path("/createUserDetail")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public void createUserDetail(UserDetails userDetail){
        userDetailService.createUserDetails(userDetail);
    }

    @Path ("/deleteUserDetail")
    @DELETE
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public void deleteUserDetail(UserDetails userDetail){
        userDetailService.deleteUserDetail(userDetail.getId());
    }

    @Path ("/updateNameUserDetail")
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public void updateNameUserDetail(UserDetails userDetail){
        userDetailService.updateUserDetailName(userDetail.getId(),userDetail.getName());
    }
    @Path ("/updateEmailUserDetail")
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public void updateEmailUserDetail(UserDetails userDetail){
        userDetailService.updateUserDetailName(userDetail.getId(),userDetail.getEmail());
    }}

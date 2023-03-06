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

import java.util.List;

@Path("userDetails")
public class UserDetailController{
    private final UserDetailService userDetailService = new UserDetailService();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<UserDetails> readUserDetails(){
        return userDetailService.getAllUserDetails();
    }

    @Path("/{createUserDetail}")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public void createUserDetail(UserDetails userDetail){
        userDetailService.createUserDetails(userDetail);
    }

    @Path ("/{deleteUserDetail}")
    @DELETE
    public void deleteUserDetail(UserDetails userDetail){
        userDetailService.deleteUserDetail(userDetail.getId());
    }

    @Path ("/{updateNameUserDetail}")
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public void updateNameUserDetail(UserDetails userDetail){
        userDetailService.updateUserDetailName(userDetail.getId(),userDetail.getName());
    }
    @Path ("/{updateEmailUserDetail}")
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public void updateEmailUserDetail(UserDetails userDetail){
        userDetailService.updateUserDetailName(userDetail.getId(),userDetail.getEmail());
    }}

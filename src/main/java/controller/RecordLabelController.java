package controller;

import entity.RecordLabels;
import jakarta.ws.rs.*;
import service.RecordLabelService;

import jakarta.ws.rs.core.MediaType;
import java.util.List;

@Path("/recordLabels")
public class RecordLabelController{
    private final RecordLabelService recordLabelService = new RecordLabelService();

    @Path("/readRecordLabels")
    @GET
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public String readRecordLabels(){
        return recordLabelService.getAllRecordLabels().toString();
    }

    @Path ("/{getRecordLabel}")
    @GET
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public String getRecordLabel(@PathParam("getRecordLabel") Long id){
        return recordLabelService.findRecordLabel(id).toString();
    }
    @Path ("/find/{findRecordLabel}")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public String findRecordLabel(@PathParam("findRecordLabel") Long id){
        return recordLabelService.findRecordLabel(id).toString();
    }

    @Path("/createRecordLabel")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public void createRecordLabel(RecordLabels recordLabels){
        recordLabelService.createRecordLabel(recordLabels);
    }

    @Path ("/deleteRecordLabel")
    @DELETE
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public void deleteRecordLabel(RecordLabels recordLabels){
        recordLabelService.deleteRecordLabel(recordLabels.getId());
    }

    @Path ("/updateRecordLabel")
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public void updateRecordLabel(RecordLabels recordLabels){
        recordLabelService.updateRecordLabelName(recordLabels.getId(),recordLabels.getName());
    }
}
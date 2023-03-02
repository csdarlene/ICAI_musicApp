package controller;

import entity.RecordLabels;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import service.RecordLabelService;

import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.core.MediaType;

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

    @Path ("/getRecordLabel")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public RecordLabels getRecordLabel(RecordLabels recordLabels){
        return recordLabelService.findRecordLabel(recordLabels.getId());
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
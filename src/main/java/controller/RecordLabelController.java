package controller;

import entity.RecordLabels;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.Response;
import service.RecordLabelService;

import jakarta.ws.rs.core.MediaType;
import java.util.List;

@Path("/recordLabels")
public class RecordLabelController{
    private final RecordLabelService recordLabelService = new RecordLabelService();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<RecordLabels> readRecordLabels(){
        return recordLabelService.getAllRecordLabels();
    }

    @Path ("/{getRecordLabel}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public RecordLabels getRecordLabel(@PathParam("getRecordLabel") Long id){
        return recordLabelService.findRecordLabel(id);
    }

    @Path ("/{id}")
    @DELETE
    public Response deleteRecordLabel(@PathParam("id") Long id) {
        recordLabelService.deleteRecordLabel(id);
        return Response.status(Response.Status.OK).build();}


    @Path("/createRecordLabel")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public void createRecordLabel(RecordLabels recordLabels){
        recordLabelService.createRecordLabel(recordLabels);
    }


    @Path ("/updateRecordLabel")
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public void updateRecordLabel(RecordLabels recordLabels){
        recordLabelService.updateRecordLabelName(recordLabels.getId(),recordLabels.getName());
    }
}
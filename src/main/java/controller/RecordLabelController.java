package controller;

import entity.RecordLabels;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.Response;
import service.RecordLabelService;

import jakarta.ws.rs.core.MediaType;

import java.util.ArrayList;
import java.util.List;

@Path("/recordLabels")
public class RecordLabelController {
    private final RecordLabelService recordLabelService = new RecordLabelService();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<RecordLabels> readRecordLabels() {
        return recordLabelService.getAllRecordLabels();
    }

    @Path("/{getRecordLabel}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<RecordLabels> getRecordLabel(@PathParam("getRecordLabel") Long id) {
        List<RecordLabels> recordLabels= new ArrayList<>();
        recordLabels.add(recordLabelService.findRecordLabel(id));
        return recordLabels;
    }

    @Path("/{id}")
    @DELETE
    public Response deleteRecordLabel(@PathParam("id") Long id) {
        recordLabelService.deleteRecordLabel(id);
        return Response.status(Response.Status.OK).build();
    }


    @Path("/create")
    @POST
    public Response createRecordLabel(@FormParam("name")String name) {
        recordLabelService.createRecordLabel(new RecordLabels(name));
        return Response.status(Response.Status.OK).build();
    }


    @Path("/{id}")
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response updateRecordLabel(@PathParam("id") Long id, String name) {
        recordLabelService.updateRecordLabelName(id, name);
        return Response.status(Response.Status.OK).build();
    }
}
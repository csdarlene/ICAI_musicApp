package controller;

import entity.Albums;
import jakarta.ws.rs.*;
import service.AlbumService;

import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.ArrayList;
import java.util.List;


@Path("/albums")
public class AlbumController {
    private final AlbumService albumService = new AlbumService();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Albums> readAlbums() {
        return albumService.getAllAlbums();
    }

    @Path("/{getAlbum}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Albums> getAlbum(@PathParam("getAlbum") Long id) {
        List<Albums> albums = new ArrayList<>();
         albums.add(albumService.findAlbum(id));
        return albums;

    }


    @Path("/{id}")
    @DELETE
    public Response deleteAlbum(@PathParam("id") Long id) {
        albumService.deleteAlbum(id);
        return Response.status(Response.Status.OK).build();
    }

    //create
    @Path("/create")
    @POST
    public Response createAlbum(@FormParam("name") String name, @FormParam("year") Integer year) {
        albumService.createAlbums(new Albums(name, year));
        return Response.status(Response.Status.OK).build();
    }


    @Path("/{id}/year")
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response updateYearAlbum(@PathParam("id") Long id, Integer year) {
        albumService.updateAlbumYear(id, year);
        return Response.status(Response.Status.OK).build();
    }

    @Path("/{id}/name")
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response updateNameAlbum(@PathParam("id") Long id, String name) {
        albumService.updateAlbumName(id, name);
        return Response.status(Response.Status.OK).build();
    }

}
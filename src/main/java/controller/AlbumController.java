package controller;

import entity.Albums;
import jakarta.ws.rs.*;
import service.AlbumService;

import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/albums")
public class AlbumController{
    private final AlbumService albumService = new AlbumService();

    @Path("/readAlbums")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String readAlbums(){
        return albumService.getAllAlbums().toString();
    }

    @Path ("/{getAlbum}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getAlbum(@PathParam("getAlbum") Long id){
        return albumService.findAlbum(id).toString();
    }
    @Path ("/find/{findAlbum}")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public String findAlbum(@PathParam("findAlbum") Long id){
        return albumService.findAlbum(id).toString();
    }

    @Path("/createAlbums")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response createAlbum(Albums albums){
        albumService.createAlbums(albums); return Response.status(Response.Status.CREATED).build();

    }

    @Path ("/deleteAlbum")
    @DELETE
    @Produces(MediaType.APPLICATION_JSON)
    public void deleteAlbum(Albums albums){
         albumService.deleteAlbum(albums.getId());
    }

    @Path ("/updateYearAlbum")
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response updateYearAlbum(Albums albums){
         albumService.updateAlbumYear(albums.getId(),albums.getYear());
        return Response.status(Response.Status.OK).build();}
    @Path ("/updateNameAlbum")
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response updateNameAlbum(Albums albums){
        albumService.updateAlbumName(albums.getId(),albums.getName());
        return Response.status(Response.Status.OK).build(); }

}
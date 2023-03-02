package controller;

import entity.Albums;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import service.AlbumService;

import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
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

    @Path ("/getAlbum")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Albums getAlbum(Albums albums){
        return albumService.findAlbum(albums.getId());
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
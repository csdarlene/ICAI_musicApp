package controller;

import entity.Albums;
import jakarta.ws.rs.*;
import service.AlbumService;

import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

@Path("/albums")
public class AlbumController {
    private final AlbumService albumService = new AlbumService();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String readAlbums() {
        return albumService.getAllAlbums().toString();
    }

    @Path("/{getAlbum}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Albums getAlbum(@PathParam("getAlbum") Long id) {
        return albumService.findAlbum(id);
    }

    @Path("/{findAlbum}")
    @POST
    @Consumes
            (MediaType.APPLICATION_JSON)
    public Albums findAlbum(@PathParam("findAlbum") Long id) {
        return albumService.findAlbum(id);
    }

    //create
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response createAlbum(Albums albums)throws URISyntaxException {
        albumService.createAlbums(albums);
        URI uri = new URI("/albums/"+albums.getId());
        return Response.created(uri).build();

    }

    @Path("/{id}")
    @DELETE
    public Response deleteAlbum(@PathParam("id") Long id) {
        albumService.deleteAlbum(id);
        return Response.status(Response.Status.OK).build();
    }

    //update year
    @Path("/{id}&{year}")
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public Response updateYearAlbum(@PathParam("id") Long id, @PathParam("year")Integer year) {
        albumService.updateAlbumYear(id, year);
        return Response.status(Response.Status.OK).build();
    }

    //update name
    @Path("/{updateNameAlbum}")
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public Response updateNameAlbum(Albums albums) {
        albumService.updateAlbumName(albums.getId(), albums.getName());
        return Response.status(Response.Status.OK).build();
    }

}
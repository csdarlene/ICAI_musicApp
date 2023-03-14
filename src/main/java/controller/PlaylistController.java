package controller;

import entity.Playlists;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.Response;
import service.PlaylistService;

import jakarta.ws.rs.core.MediaType;

import java.util.List;

@Path("playlists")
public class PlaylistController {
    private final PlaylistService playlistService = new PlaylistService();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Playlists> readPlaylists() {
        return playlistService.getAllPlaylists();
    }

    @Path("/{getPlaylist}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Playlists getPlaylist(@PathParam("getPlaylist") Long id) {
        return playlistService.findPlaylist(id);
    }


    @Path("/UserPlaylist/{username}")
    @GET
    @Consumes(MediaType.APPLICATION_JSON)
    public List<Playlists> getUserPlaylist(@PathParam("username") String name) {
        return playlistService.getUserPlaylist(name);
    }

    @Path("/{id}")
    @DELETE
    public Response deletePlaylist(@PathParam("id") Long id) {
        playlistService.deletePlaylist(id);
        return Response.status(Response.Status.OK).build();

    }

    @Path("/create")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Playlists createPlaylist(Playlists playlists) {
        return playlistService.createPlaylists(playlists);
    }


    @Path("/{id}")
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response updatePlaylist(@PathParam("id") Long id, String name) {
        playlistService.updatePlaylistName(id, name);
        return Response.status(Response.Status.OK).build();
    }
}
package controller;

import entity.Playlists;
import jakarta.ws.rs.*;
import service.PlaylistService;

import jakarta.ws.rs.core.MediaType;

import java.util.List;

@Path("playlists")
public class PlaylistController{
    private final PlaylistService playlistService = new PlaylistService();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Playlists> readPlaylists(){
        return playlistService.getAllPlaylists();
    }

    @Path ("/{getPlaylist}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Playlists getPlaylist(@PathParam( "getPlaylist") Long id){
        return playlistService.findPlaylist(id);
    }

    @Path ("/{findPlaylist}")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Playlists findPlaylist(@PathParam( "findPlaylist") Long id){
        return playlistService.findPlaylist(id);
    }

    @Path ("/getUserPlaylist")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public void getUserPlaylist(Playlists playlists){
        playlistService.getUserPlaylist(playlists.getName());
    }

    @Path("/createPlaylist")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public void createPlaylist(Playlists playlists){
        playlistService.createPlaylists(playlists);
    }

    @Path ("/deletePlaylist")
    @DELETE
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public void deletePlaylist(Playlists playlists){
        playlistService.deletePlaylist(playlists.getId());
    }

    @Path ("/updatePlaylist")
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public void updatePlaylist(Playlists playlists){
        playlistService.updatePlaylistName(playlists.getId(),playlists.getName());
    }}
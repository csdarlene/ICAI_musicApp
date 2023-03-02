package controller;

import entity.Songs;
import jakarta.ws.rs.*;
import service.SongService;

import jakarta.ws.rs.core.MediaType;
import java.util.List;

@Path("songs")
public class SongController{
    private final SongService songService = new SongService();

    @Path("/readSongs")
    @GET
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public String readSongs(){
        return songService.getAllSongs().toString();
    }

    @Path ("/{getSong}")
    @GET
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public String getSong(@PathParam("getSong") Long id){
        return songService.findSong(id).toString();
    }

    @Path ("/find/{findSong}")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public String findSong(@PathParam("findSong") Long id){
        return songService.findSong(id).toString();
    }


    @Path ("/getSongArtist")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public void getSongArtsit(Songs songs){
         songService.getArtistSong(songs.getName());
    }

    @Path("/createSong")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public void createSong(Songs Songs){
        songService.createSongs(Songs);
    }

    @Path ("/deleteSong")
    @DELETE
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public void deleteSong(Songs songs){
        songService.deleteSong(songs.getId());
          }

    @Path ("/updateSong")
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public void updateSong(Songs songs){
        songService.updateSongName(songs.getId(),songs.getName());
    }}
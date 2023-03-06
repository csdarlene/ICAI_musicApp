package controller;

import entity.Songs;
import jakarta.ws.rs.*;
import service.SongService;

import jakarta.ws.rs.core.MediaType;
import java.util.List;

@Path("songs")
public class SongController{
    private final SongService songService = new SongService();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Songs> readSongs(){
        return songService.getAllSongs();
    }

    @Path ("/{getSong}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Songs getSong(@PathParam("getSong") Long id){
        return songService.findSong(id);
    }

    @Path ("/{findSong}")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Songs findSong(@PathParam("findSong") Long id){
        return songService.findSong(id);
    }

    @Path ("/{getSongArtist}")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public void getSongArtsit(Songs songs){
         songService.getArtistSong(songs.getName());
    }

    @Path("/{createSong}")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public void createSong(Songs Songs){
        songService.createSongs(Songs);
    }

    @Path ("/{deleteSong}")
    @DELETE
    public void deleteSong(Songs songs){
        songService.deleteSong(songs.getId());
          }

    @Path ("/{updateSong}")
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public void updateSong(Songs songs){
        songService.updateSongName(songs.getId(),songs.getName());
    }}
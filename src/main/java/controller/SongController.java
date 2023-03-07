package controller;

import entity.Songs;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.Response;
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

    @Path ("/SongArtist/{name}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getSongArtist(@PathParam("name") String name){
         return songService.getArtistSong(name).toString();
   }

    @Path ("/{id}")
    @DELETE
    public Response deleteSong(@PathParam("id") Long id) {
        songService.deleteSong(id);
        return Response.status(Response.Status.OK).build();
    }

    @Path("/createSong")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public void createSong(Songs Songs){
        songService.createSongs(Songs);
    }


    @Path ("/updateSong")
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public void updateSong(Songs songs){
        songService.updateSongName(songs.getId(),songs.getName());
    }}
package controller;

import entity.Songs;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.Response;
import service.SongService;

import jakarta.ws.rs.core.MediaType;

import java.util.ArrayList;
import java.util.List;

@Path("songs")
public class SongController {
    private final SongService songService = new SongService();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Songs> readSongs() {
        return songService.getAllSongs();
    }

    @Path("/{getSong}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Songs> getSong(@PathParam("getSong") Long id) {
        List<Songs> songs = new ArrayList<>();
        songs.add(songService.findSong(id));
        return songs;
    }

    @Path("/SongArtist/{name}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getSongArtist(@PathParam("name") String name) {
        return songService.getArtistSong(name).toString();
    }

    @Path("/{id}")
    @DELETE
    public Response deleteSong(@PathParam("id") Long id) {
        songService.deleteSong(id);
        return Response.status(Response.Status.OK).build();
    }

    @Path("/create")
    @POST
    public Response createSong(@FormParam("time") Double time, @FormParam("name") String name) {
        songService.createSongs(new Songs(name, time));
        return Response.status(Response.Status.OK).build();
    }


    @Path("/{id}")
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response updateSong(@PathParam("id") Long id, String name) {
        songService.updateSongName(id, name);
        return Response.status(Response.Status.OK).build();
    }
}
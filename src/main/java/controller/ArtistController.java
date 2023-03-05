package controller;

import entity.Artists;
import jakarta.ws.rs.*;
import service.ArtistService;

import jakarta.ws.rs.core.MediaType;

import java.util.List;


@Path("artists")
public class ArtistController {
    private final ArtistService artistService = new ArtistService();

    @Path("/readArtists")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Artists> readArtists() {
        return artistService.getAllArtists();
    }


    @Path("/{getArtist}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Artists getArtist(@PathParam("getArtist") Long id) {
        return artistService.findArtist(id);
    }

    @Path("/find/{findArtist}")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Artists findArtist(@PathParam("findArtist") Long id) {
        return artistService.findArtist(id);
    }

    @Path("/createArtists")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public void createArtist(Artists artists) {
        artistService.createArtist(artists);
    }

    @Path("/deleteArtist")
    @DELETE
    public void deleteArtist(Artists artists) {
        artistService.deleteArtist(artists.getId());
    }

    @Path("/updateArtist")
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public void updateArtist(Artists artists) {
        artistService.updateArtistName(artists.getId(), artists.getName());
    }


}

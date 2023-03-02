package controller;

import entity.Artists;
import jakarta.ws.rs.*;
import service.ArtistService;

import jakarta.ws.rs.core.MediaType;


@Path("artists")
public class ArtistController {
    private final ArtistService artistService = new ArtistService();

    @Path("/readArtists")
    @GET
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public String readArtists() {
        return artistService.getAllArtists().toString();
    }


    @Path("/{getArtist}")
    @GET
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public String getArtist(@PathParam("getArtist") Long id) {
        return artistService.findArtist(id).toString();
    }

    @Path("/find/{findArtist}")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public String findArtist(@PathParam("findArtist") Long id) {
        return artistService.findArtist(id).toString();
    }

    @Path("/createArtists")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public void createArtist(Artists artists) {
        artistService.createArtist(artists);
    }

    @Path("/deleteArtist")
    @DELETE
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public void deleteArtist(Artists artists) {
        artistService.deleteArtist(artists.getId());
    }

    @Path("/updateArtist")
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public void updateArtist(Artists artists) {
        artistService.updateArtistName(artists.getId(), artists.getName());
    }


}

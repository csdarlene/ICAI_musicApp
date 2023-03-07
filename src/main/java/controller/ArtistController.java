package controller;

import entity.Artists;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.Response;
import service.ArtistService;
import jakarta.ws.rs.core.MediaType;

@Path("artists")
public class ArtistController {
    private final ArtistService artistService = new ArtistService();


    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String readArtists() {
        return artistService.getAllArtists().toString();
    }


    @Path("/{getArtist}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Artists getArtist(@PathParam("getArtist") Long id) {
        return artistService.findArtist(id);
    }


    @Path("/{id}")
    @DELETE
    public Response deleteArtist(@PathParam("id") Long id) {
        artistService.deleteArtist(id);
        return Response.status(Response.Status.OK).build();
    }

    @Path("/createArtists")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public void createArtist(Artists artists) {
        artistService.createArtist(artists);
    }


    @Path("/updateArtist")
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public void updateArtist(Artists artists) {
        artistService.updateArtistName(artists.getId(), artists.getName());
    }


}

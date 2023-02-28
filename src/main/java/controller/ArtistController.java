package controller;

import entity.Artists;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import service.ArtistService;

import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.core.MediaType;
import java.util.List;

@Path("artists")
public class ArtistController {
    private final ArtistService artistService = new ArtistService();

    @Path("/readArtists")
    @GET
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public List<Artists> readArtists() {
        return artistService.getAllArtists();
    }

    @Path("/readArtist")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Artists getArtist(Artists artists) {
        return artistService.findArtist(artists.getId());
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

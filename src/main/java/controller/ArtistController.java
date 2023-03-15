package controller;

import entity.Artists;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.Response;
import service.ArtistService;
import jakarta.ws.rs.core.MediaType;

import java.util.List;

@Path("artists")
public class ArtistController {
    private final ArtistService artistService = new ArtistService();

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

    @Path("/{id}")
    @DELETE
    public Response deleteArtist(@PathParam("id") Long id) {
        artistService.deleteArtist(id);
        return Response.status(Response.Status.OK).build();
    }

    @Path("/create")
    @POST
    public Response createArtist(@FormParam("name") String name) {
        artistService.createArtist(new Artists(name));
        return Response.status(Response.Status.OK).build();
    }

    @Path("/{id}")
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response updateArtist(@PathParam("id") Long id, String name) {
        artistService.updateArtistName(id, name);
        return Response.status(Response.Status.OK).build();
    }

}

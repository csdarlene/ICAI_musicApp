package controller;

import entity.Artists;
import entity.Playlists;
import entity.RecordLabels;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.Response;
import service.ArtistService;
import jakarta.ws.rs.core.MediaType;
import service.RecordLabelService;

import java.util.ArrayList;
import java.util.List;

@Path("artists")
public class ArtistController {
    private final ArtistService artistService = new ArtistService();
    private final RecordLabelService recordLabelService = new RecordLabelService();


    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Artists> readArtists() {
        return artistService.getAllArtists();
    }

    @Path("/{getArtist}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Artists> getArtist(@PathParam("getArtist") Long id) {
        List<Artists> artists=new ArrayList<>();
        artists.add(artistService.findArtist(id));
        return artists;
    }


    @Path("/artistAlbum")
    @GET
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public List<Artists> getArtistAlbum(String album) {
        return artistService.getArtistAlbum(album);
    }

    @Path("/{id}")
    @DELETE
    public Response deleteArtist(@PathParam("id") Long id) {
        artistService.deleteArtist(id);
        return Response.status(Response.Status.OK).build();
    }

    @Path("/create")
    @POST
    public Response createArtist(@FormParam("name") String name, @FormParam("recordLabel") Long recordLabel) {
        RecordLabels recordLabels=recordLabelService.findRecordLabel(recordLabel);
        artistService.createArtist(new Artists(name, recordLabels));
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

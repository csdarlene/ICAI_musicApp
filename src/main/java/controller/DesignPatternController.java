package controller;

import designPatterns.patternBehavioral.ChainOfResponsibility.MainBehavioral;
import designPatterns.patternBehavioral.ManyToManyMapping.PlaylistSongs;
import designPatterns.patternCreational.Prototype2.MainCreational2;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;

@Path("/design")
public class DesignPatternController {

    @Path("/behavioral")
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String behavioral(@QueryParam("artist") String artist, @QueryParam("song") String song){
        return MainBehavioral.linkSongToArtist(artist,song);
    }

    @Path("/behavioral2")
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String behavioral2(@QueryParam("playlist") String playlist, @QueryParam("songs") String songs){
        return PlaylistSongs.linkSongToPlaylist(playlist,songs);
    }

    @Path("/creational")
    @GET
    @Produces("text/plain")
    public String creational(){
        return MainCreational2.MainCreational();   }
 }


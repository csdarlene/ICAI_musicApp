package controller;

import designPatterns.patternBehavioral.ChainOfResponsibility.MainBehavioral;
import designPatterns.patternCreational.Prototype2.MainCreational2;
import designPatterns.patternStructural.Composite.MainComposite;

import designPatterns.patternStructural.Proxy.MainProxy;
import jakarta.ws.rs.*;



@Path("design")
public class DesignPatternController {

    static MainComposite mainComposite= new MainComposite();
    static MainProxy mainProxy= new MainProxy();

    @Path("/behavioral")
    @GET
    @Produces("text/plain")
    public String behavioral(@FormParam("artist") String artist, @FormParam("song") String song){
        return MainBehavioral.linkSongToArtist(artist,song);
    }


    @Path("/creational2")
    @GET
    @Produces("text/plain")
    public String creational2(){
        return MainCreational2.MainCreational();   }

 }


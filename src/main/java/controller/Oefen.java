package controller;

import jakarta.ws.rs.*;

@Path("/oefen")
public class Oefen {
    @GET
    @Produces("text/plain")
    public String hello() {
        return "Hello, World!";
    }

    @Path("/darlene")
    @GET
    @Produces("text/plain")
    public String dar() {
        return "hi Darlene";
    }
}
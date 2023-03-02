package controller;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;

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
    public String dar(){
        return "hi Darlene";
    }
}
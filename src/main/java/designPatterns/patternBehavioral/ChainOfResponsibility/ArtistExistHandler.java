package designPatterns.patternBehavioral.ChainOfResponsibility;

import entity.Artists;
import service.ArtistService;

public class ArtistExistHandler extends Handler {

    ArtistService artistService = new ArtistService();

    public ArtistExistHandler() {
    }

    @Override
    public boolean handle( String artist, String song ) {
        for (Artists a : artistService.getAllArtists()) {
            if (a.getName().equals(artist)) {
                if (a.getRecordLabelID()==null) {
                    System.out.println("Approved by artist \n");
                    return true;
                }
            }

        }

        return handleNext(artist, song);
    }


}
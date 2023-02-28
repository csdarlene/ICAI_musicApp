package designPatterns.patternBehavioral.ChainOfResponsibility;

import entity.Artists;
import service.ArtistService;

public class RecordLabelExistHandler extends Handler {

    ArtistService artistService = new ArtistService();

    @Override
    public boolean handle( String artist, String song ) {
        for (Artists a : artistService.getAllArtists()) {
            if (a.getName().equals(artist)) {
                if (a.getRecordLabelID().getId() >= 0) {
                    System.out.println("Approved by record label \n");
                    return true;
                }
            }

        }

        return

                handleNext(artist, song);
    }


}

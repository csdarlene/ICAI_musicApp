package designPatterns.patternBehavioral.ChainOfResponsibility;

import entity.Artists;
import entity.Songs;
import service.ArtistService;
import service.SongService;

public class ServiceBehavioral {
    private final Handler handler;
    ArtistService artistService = new ArtistService();
    SongService songService = new SongService();

    public ServiceBehavioral( Handler handler ) {
        this.handler = handler;
    }

    public String SongArtist( String artist, String song ) {
        if (handler.handle(artist, song)) {
            for (Artists a : artistService.getAllArtists()) {
                if (a.getName().equals(artist)) {
                    for (Songs s : songService.getAllSongs()) {
                        if (s.getName().equals(song)) {

                            Long idSong = s.getId();
                            Long idArtist = a.getId();

                            artistService.findArtist(idArtist).getSongSet().add(songService.findSong(idSong));
                            songService.findSong(idSong).getArtistSet().add(artistService.findArtist(idArtist));
                            songService.getArtistSong(song);
                           return "Update was successful!";

                        }
                    }
                }
            }
            return "\nSong or artist doesn't appears in the database";

        }
        return null;
    }
}

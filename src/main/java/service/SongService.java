package service;

import configuration.JPAConfiguration;
import entity.Songs;
import repository.SongRepository;

import java.util.List;

public class SongService {
    private final SongRepository songRepository;

    public SongService() {
        this.songRepository =
                new SongRepository(JPAConfiguration.getEntityManager());
    }

    public List<Songs> getAllSongs() {
        return songRepository.getAllSongs();
    }

    public Songs createSongs(Songs songs) {
        return songRepository.createSongs(songs);
    }

    public void updateSongName(Long id, String name) {
        songRepository.updateSongName(id, name);
    }

    public Songs deleteSong(Long id) {
        return songRepository.deleteSong(id);
    }

    public Songs findSong(Long id) {
        return songRepository.findSong(id);
    }

    public List<Songs> getArtistSong(String song) {
        return songRepository.getArtistSong(song);

    }
}

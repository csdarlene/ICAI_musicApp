package service;

import configuration.JPAConfiguration;
import entity.Playlists;
import entity.Songs;
import repository.PlaylistRepository;

import java.util.List;

public class PlaylistService {
    private final PlaylistRepository playlistRepository;

    public PlaylistService() {
        this.playlistRepository = new PlaylistRepository(JPAConfiguration.getEntityManager());
    }

    public List<Playlists> getAllPlaylists() {
        return playlistRepository.getAllPlaylists();
    }

    public List<Playlists> getUserPlaylist(String username) {
        return playlistRepository.getUserPlaylist(username);
    }

    public Playlists createPlaylists(Playlists playlist) {
        return playlistRepository.createPlaylists(playlist);
    }

    public Playlists deletePlaylist(Long id) {
        return playlistRepository.deletePlaylist(id);
    }

    public Playlists updatePlaylistName(Long id, String name) {
        return playlistRepository.updatePlaylistName(id, name);
    }

    public Playlists findPlaylist(Long id) {

        return playlistRepository.findPlaylist(id);
    }

    public List<Playlists> getPlaylistSong(String playlist) {
        return playlistRepository.getPlaylistSong(playlist);

    }
}

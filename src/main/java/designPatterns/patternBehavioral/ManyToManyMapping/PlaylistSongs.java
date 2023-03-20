package designPatterns.patternBehavioral.ManyToManyMapping;


import entity.Playlists;
import entity.Songs;
import service.PlaylistService;
import service.SongService;

public class PlaylistSongs {
    static PlaylistService playlistService = new PlaylistService();
    static SongService songService = new SongService();

    public static String linkSongToPlaylist(String playlist, String song) {
        for (Playlists playlists : playlistService.getAllPlaylists()) {
            if (playlists.getName().equals(playlist)) {
                for (Songs songs : songService.getAllSongs()) {
                    if (songs.getName().equals(song)) {
                        Long idsong = songs.getId();
                        Long idPlaylist = playlists.getId();

                        playlistService.findPlaylist(idPlaylist).getSongSet().add(songService.findSong(idsong));
                        songService.findSong(idsong).getPlaylistSet().add(playlistService.findPlaylist(idPlaylist));
                        PlaylistService playlistService = new PlaylistService();
                        playlistService.getPlaylistSong(playlist);
                        return "Update was successful!";

                    }
                }
            }
        }
        return "\nsong or playlist doesn't appears in the database";

    }


    public static void main(String[] args) {
        System.out.println(linkSongToPlaylist("Favs", "Phases"));

    }
}
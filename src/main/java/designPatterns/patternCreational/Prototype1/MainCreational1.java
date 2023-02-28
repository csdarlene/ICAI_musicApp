package designPatterns.patternCreational.Prototype1;

import entity.Playlists;
import entity.Songs;
import service.PlaylistService;
import service.SongService;

import java.util.Scanner;
import java.util.Set;

public class MainCreational1 {
    public static void MainCreational() throws CloneNotSupportedException {
        Scanner sc = new Scanner(System.in);
        PlaylistDAO1 playlistDAO1 = new PlaylistDAO1();
        PlaylistService playlistService = new PlaylistService();
        SongService songService = new SongService();

        System.out.println("Original Playlists:");
        for (Playlists p : playlistService.getAllPlaylists()) {
            System.out.println(p.getName());
        }

        Set<Songs> clonePlaylist = playlistDAO1.clone();

        System.out.println("Duplicated Playlist:");
        System.out.println(clonePlaylist);

        System.out.println("Do you want to add a song to the playlist? \n yes or no");
        String ch = sc.nextLine().toLowerCase();
        if (ch.equals("yes")) {
            System.out.println("Enter Song:");
            String song = sc.nextLine().toLowerCase();
            for (Songs s : songService.getAllSongs()) {
                if ((s.getName().toLowerCase()).equals(song)) {
                    clonePlaylist.add(s);

                    System.out.println("Updated Duplicated Playlist:");
                    System.out.println(clonePlaylist);
                }
            }
        }


    }
}


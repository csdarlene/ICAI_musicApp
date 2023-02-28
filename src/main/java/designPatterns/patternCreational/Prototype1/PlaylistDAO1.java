package designPatterns.patternCreational.Prototype1;

import entity.Playlists;
import entity.Songs;
import service.PlaylistService;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class PlaylistDAO1 implements Cloneable {
    private final Set<Songs> cloneSet;
    PlaylistService playlistService = new PlaylistService();

    public PlaylistDAO1() {
        this.cloneSet = new HashSet<>();
    }

    @Override
    public Set<Songs> clone() throws CloneNotSupportedException {
        System.out.println("Please enter playlist name:");
        Scanner scanner = new Scanner(System.in);
        String name = scanner.nextLine();
        for (Playlists p : playlistService.getAllPlaylists()) {
            if (p.getName().equals(name)) {
                cloneSet.addAll(p.getSongSet());
            }
        }
        return cloneSet;
    }
}

package designPatterns.patternCreational.Prototype2;

import entity.Songs;

import java.util.Set;

public class PlaylistDAO2 implements Cloneable {
    int id;
    String name;
    Set<Songs> songSet ;

    public PlaylistDAO2() {

    }

    public Set<Songs> getSongSet() {
        return songSet;
    }

    @Override
    public String toString() {
        return "Playlists: " +
                "id=" + id +
                ", name= " + name +
                " " + getSongSet() + "\n";
    }

    public PlaylistDAO2( int id, String name, Set<Songs> songSet ) {
        this.id = id;
        this.name = name;
        this.songSet = songSet;
    }

    @Override
    public PlaylistDAO2 clone() {
        try {
            return (PlaylistDAO2) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }
}

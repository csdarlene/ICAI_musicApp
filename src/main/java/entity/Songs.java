package entity;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
public class Songs {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private Double time;

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(name = "artist_songs",
            joinColumns = {@JoinColumn(name = "song_id")},
            inverseJoinColumns = {@JoinColumn(name = "artist_id")},
            uniqueConstraints = {
                    @UniqueConstraint(columnNames = {"artist_id", "song_id"})})

    private List<Artists> artistSet = new ArrayList<>();

    @ManyToOne
    private Albums album;

    @ManyToMany(mappedBy = "songSet")
    private Set<Playlists> playlistSet = new HashSet<>();

    public Songs() {
    }

    public Songs(String name, Double time, Albums album_id) {
        this.name = name;
        this.time = time;
        this.album = album_id;
    }

    public Songs(Long id, String name, Double time) {
        this.id = id;
        this.name = name;
        this.time = time;
    }

    public Songs(String name, Double time) {
        this.name = name;
        this.time = time;
    }

    public Albums getAlbumID() {
        return album;
    }

    public void setAlbumID(Albums album_id) {
        this.album = album_id;
    }

    public List<Artists> getArtistSet() {
        return artistSet;
    }

    public Set<Playlists> getPlaylistSet() {
        return playlistSet;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getTime() {
        return time;
    }

    public void setTime(Double time) {
        this.time = time;
    }

    @Override
    public String toString() {
        return "Songs: " +
                "id=" + id +
                ", name= " + name +
                ", time= " + time +
                album;
    }
}

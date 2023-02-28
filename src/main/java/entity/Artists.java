package entity;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
public class Artists {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @ManyToOne
    private RecordLabels record_label;

    @ManyToMany(mappedBy = "artistSet")
    private Set<Songs> songSet = new HashSet<>();

    @ManyToMany(cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
    @JoinTable( name = "artist_albums",
                joinColumns = {@JoinColumn(name = "artist_id")},
                inverseJoinColumns = {@JoinColumn(name = "album_id")},
                uniqueConstraints = {
            @UniqueConstraint(columnNames = {"artist_id", "album_id"})})

    private Set<Albums> albumSet = new HashSet<>();

    public Artists() {
    }

    public Artists( String name, RecordLabels record_label_id ) {
        this.name = name;
        this.record_label = record_label_id;
    }

    public Set<Albums> getAlbumSet() {
        return albumSet;
    }

    public Set<Songs> getSongSet() {
        return songSet;
    }

    public RecordLabels getRecordLabelID() {
        return record_label;
    }

    public void setRecordLabelID( RecordLabels record_label_id ) {
        this.record_label = record_label_id;
    }

    public Long getId() {
        return id;
    }

    public void setId( Long id ) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName( String name ) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Artists:" +
                "id=" + id +
                ", name= " + name + " " +
                record_label;
    }
}

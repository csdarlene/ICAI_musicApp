package entity;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
public class Albums {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private Integer year;

    @OneToMany
    @JoinColumn(name = "album_id")
    private List<Songs> songList;

    @ManyToMany(mappedBy = "albumSet")
    private Set<Artists> artistSet = new HashSet<>();

    public Albums() {
    }

    public Albums( String name, Integer year ) {
        this.name = name;
        this.year = year;
    }

    public Set<Artists> getArtistSet() {
        return artistSet;
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

    public Integer getYear() {
        return year;
    }

    public void setYear( Integer year ) {
        this.year = year;
    }

    @Override
    public String toString() {
        return "Album" +
                "id=" + id +
                ", name=" + name +
                ", year=" + year+"\n";
    }
}


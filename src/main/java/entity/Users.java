package entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Users {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    private String username;

    @Column(nullable = false)
    private String password;


    @OneToOne
    @JoinColumn(name = "userDetails_id")
    private UserDetails userDetails;

    @OneToMany
    @JoinColumn(name = "user_id")
    private List<Playlists> playLists;

    public Users() {
    }

    public Users(String username, String password, UserDetails userDetails) {
        this.username = username;
        this.password = password;
        this.userDetails = userDetails;
    }

    public Users(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Playlists> getPlayLists() {
        return playLists;
    }

    public void setPlayLists(List<Playlists> playLists) {
        this.playLists = playLists;
    }

    public void setUserDetails(UserDetails userDetails) {
        this.userDetails = userDetails;
    }


    public UserDetails getUserDetails() {
        return userDetails;
    }

    @Override
    public String toString() {
        return "Users: " +
                "id=" + id +
                ", username= " + username +
                ", password = ******* " +
                userDetails;
    }
}


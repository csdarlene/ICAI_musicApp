package entity;

import jakarta.persistence.*;

@Entity
public class UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    private String birthday;

    @Column(unique=true, nullable = false)
    private String email;

    public UserDetails() {
    }

    public UserDetails( String name, String birthday, String email ) {
        this.name = name;
        this.birthday = birthday;
        this.email = email;
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

    public void setBirthday( String birthday ) {
        this.birthday = birthday;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail( String email ) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "UserDetails: " +
                "id=" + id +
                ", name= " + name  +
                ", birthday= " + birthday +
                ", email= " + email + "\n";
    }
}

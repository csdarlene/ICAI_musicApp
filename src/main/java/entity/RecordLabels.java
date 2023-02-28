package entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class RecordLabels {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique=true)
    private String name;

    @OneToMany
    @JoinColumn(name = "record_label_id")
    private List<Artists> artistsList;

    public RecordLabels() {
    }

    public RecordLabels( String name ) {
        this.name = name;
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
        return "RecordLabel: " +
                "id=" + id +
                ", name= " + name+ "\n";
    }
}

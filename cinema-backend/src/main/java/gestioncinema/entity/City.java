package gestioncinema.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;
@Data
@Entity
public class City implements Serializable {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 50)
    private String name;

    @OneToMany(mappedBy = "city")
    private Collection<Cinema> cinemas;

    // constructors
    public City() { }

    public City(String name) {
        this.name = name;
    }

    public City(String name, Collection<Cinema> cinemas) {
        this.name = name;
        this.cinemas = cinemas;
    }

}

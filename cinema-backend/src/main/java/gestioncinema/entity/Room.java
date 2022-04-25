package gestioncinema.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;
@Data
@Entity
public class Room implements Serializable {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 50)
    private String name;

    private int countSeats;

    @ManyToOne
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Cinema cinema;

    @OneToMany(mappedBy = "room")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Collection<Seat> seats;

    @OneToMany(mappedBy = "room")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Collection<ProjectionMovie> projectionMovies;

    // constructors
    public Room() {
    }

    public Room(String name, int countSeats, Cinema cinema) {
        this.name = name;
        this.countSeats = countSeats;
        this.cinema = cinema;
    }

}

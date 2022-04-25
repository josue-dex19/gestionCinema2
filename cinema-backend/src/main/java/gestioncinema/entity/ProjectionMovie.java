package gestioncinema.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;
@Data
@Entity
public class ProjectionMovie implements Serializable {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String dateProjection;
    private double price;

    @ManyToOne
    private Room room;

    @ManyToOne
    private Movie movie;

    @OneToMany(mappedBy = "projectionMovie")
    private Collection<Ticket> tickets;

    @ManyToOne
    private Session session;

    // constructor
    public ProjectionMovie() {
    }

    public ProjectionMovie(String dateProjection, double price) {
        this.dateProjection = dateProjection;
        this.price = price;
    }

    public ProjectionMovie(String dateProjection, double price, Room room, Movie movie, Session session) {
        this.dateProjection = dateProjection;
        this.price = price;
        this.room = room;
        this.movie = movie;
        this.session = session;
    }


}

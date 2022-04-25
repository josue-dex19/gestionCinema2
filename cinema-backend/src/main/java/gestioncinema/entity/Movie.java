package gestioncinema.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;
@Data
@Entity
public class Movie implements Serializable {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 50)
    private String title;

    @Column(length = 50)
    private String director;

    private String duration;
    private String releaseDate;

    @OneToMany(mappedBy = "movie")
    private Collection<ProjectionMovie> projectionMovies;

    // constructors
    public Movie() {
    }

    public Movie(String title, String director, String duration, String releaseDate) {
        this.title = title;
        this.director = director;
        this.duration = duration;
        this.releaseDate = releaseDate;
    }

}

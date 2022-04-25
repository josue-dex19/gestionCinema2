package gestioncinema.entity;

import lombok.Data;

import javax.persistence.*;
@Data
@Entity
public class Review {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String message;
    @ManyToOne
    private Movie movie;
    @ManyToOne
    private User user;

    // constructors
    public Review() {
    }
    public Review(String message) {
        this.message = message;
    }

    public Review(String message, Movie movie) {
        this.message = message;
        this.movie = movie;
    }

    public Review(String message, Movie movie, User user) {
        this.message = message;
        this.movie = movie;
        this.user = user;
    }


}

package gestioncinema.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
@Data
@Entity
public class Ticket implements Serializable {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 50)
    private String nameClient;

    private double price;
    private String paymentCode;
    private boolean reserve;

    @ManyToOne
    private Seat seat;

    @ManyToOne
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private ProjectionMovie projectionMovie;

    // constructors
    public Ticket() {
    }

    public Ticket(String nameClient, double price, boolean reserve, Seat seat, ProjectionMovie projectionMovie) {
        this.nameClient = nameClient;
        this.price = price;
        this.reserve = reserve;
        this.seat =seat;
        this.projectionMovie = projectionMovie;
    }

   }

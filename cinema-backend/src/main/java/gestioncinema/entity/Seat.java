package gestioncinema.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;
@Data
@Entity
public class Seat implements Serializable {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int number;

    @OneToMany(mappedBy = "seat")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Collection<Ticket> tickets;

    @ManyToOne
    private Room room;

    // constructors
    public Seat() {
    }

    public Seat(int number, Collection<Ticket> tickets, Room room) {
        this.number = number;
        this.tickets = tickets;
        this.room = room;
    }

    public Seat(int number, Room room) {
        this.number = number;
        this.room = room;
    }

}

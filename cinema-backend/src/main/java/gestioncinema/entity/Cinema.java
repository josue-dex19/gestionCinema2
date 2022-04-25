package gestioncinema.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;
@Data
@Entity
public class Cinema implements Serializable {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 50)
    private String name;

    private String address;
    private int countRooms;

    @OneToMany(mappedBy = "cinema")
    private Collection<Room> rooms;

    @ManyToOne
    private City city;

    // constructors
    public Cinema() {}

    public Cinema(String name, String address, int countRooms) {
        this.name = name;
        this.address = address;
        this.countRooms = countRooms;
    }

    public Cinema(String name, String address, int countRooms, City city) {
        this.name = name;
        this.address = address;
        this.countRooms = countRooms;
        this.city = city;
    }


}

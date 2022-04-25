package gestioncinema.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
@Data
@Entity
public class Session implements Serializable {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 50)
    private String hourStart;

    // constructors
    public Session() {
    }

    public Session(String hourStart) {
        this.hourStart = hourStart;
    }


}

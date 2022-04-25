package gestioncinema.entity;

import lombok.Data;

import javax.persistence.*;
@Data
@Entity
public class User {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String email;
    private String username;
    private String password;
    private boolean enabled;

    // constructors
    public User() {
    }
    public User(String email, String username, String password) {
        this.email = email;
        this.username = username;
        this.password = password;
    }


}

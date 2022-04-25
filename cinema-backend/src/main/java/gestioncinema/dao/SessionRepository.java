package gestioncinema.dao;

import gestioncinema.entity.Session;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin("*")
public interface SessionRepository extends JpaRepository<Session, Long> {

}

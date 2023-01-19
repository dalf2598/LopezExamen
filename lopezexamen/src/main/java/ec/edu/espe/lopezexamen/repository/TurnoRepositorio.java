package ec.edu.espe.lopezexamen.repository;

import ec.edu.espe.lopezexamen.model.Turno;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TurnoRepositorio extends MongoRepository<Turno, String > {
}

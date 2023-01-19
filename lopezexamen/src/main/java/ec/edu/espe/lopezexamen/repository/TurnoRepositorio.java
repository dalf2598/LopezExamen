package ec.edu.espe.lopezexamen.repository;

import ec.edu.espe.lopezexamen.model.Turno;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface TurnoRepositorio extends MongoRepository<Turno, String > {
}

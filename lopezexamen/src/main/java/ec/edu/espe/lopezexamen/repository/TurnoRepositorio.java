package ec.edu.espe.lopezexamen.repository;

import ec.edu.espe.lopezexamen.model.Turno;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TurnoRepositorio extends MongoRepository<Turno, String > {
    Optional<Turno> findByNumero(Integer numero);
}

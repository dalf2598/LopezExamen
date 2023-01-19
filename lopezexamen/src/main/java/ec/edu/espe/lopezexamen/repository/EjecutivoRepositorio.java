package ec.edu.espe.lopezexamen.repository;

import ec.edu.espe.lopezexamen.model.Ejecutivo;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EjecutivoRepositorio extends MongoRepository<Ejecutivo, String> {
}

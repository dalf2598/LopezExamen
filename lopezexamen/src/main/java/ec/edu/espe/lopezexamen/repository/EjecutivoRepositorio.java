package ec.edu.espe.lopezexamen.repository;

import ec.edu.espe.lopezexamen.model.Ejecutivo;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface EjecutivoRepositorio extends MongoRepository<Ejecutivo, String> {
}

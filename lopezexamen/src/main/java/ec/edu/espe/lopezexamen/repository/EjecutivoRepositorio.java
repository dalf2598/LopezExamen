package ec.edu.espe.lopezexamen.repository;

import ec.edu.espe.lopezexamen.model.Ejecutivo;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EjecutivoRepositorio extends MongoRepository<Ejecutivo, String> {
    Optional<Ejecutivo> findByCodigoUsuario(String codigoUsuario);
}

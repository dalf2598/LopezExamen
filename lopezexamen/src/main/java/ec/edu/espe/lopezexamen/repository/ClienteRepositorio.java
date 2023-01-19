package ec.edu.espe.lopezexamen.repository;

import ec.edu.espe.lopezexamen.model.Cliente;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ClienteRepositorio extends MongoRepository<Cliente, String> {
}

package ec.edu.espe.lopezexamen.repository;

import ec.edu.espe.lopezexamen.model.Cliente;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ClienteRepositorio extends MongoRepository<Cliente, String> {

    Optional<Cliente> findByCedula(String cedula);

}

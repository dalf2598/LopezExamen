package ec.edu.espe.lopezexamen.model;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Version;
import org.springframework.data.mongodb.core.mapping.Document;

@Builder
@Data
@Document(collection = "ejecutivos")
public class Ejecutivo {

    @Id
    private String id;

    private String codigoUsuario;

    private String nombreCompleto;

    private String numeroEscritorio;

    @Version
    private Long version;
}

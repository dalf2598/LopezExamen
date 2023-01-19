package ec.edu.espe.lopezexamen.model;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Version;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.List;

@Data
@Builder
@Document(collection = "clientes")
public class Cliente {

    @Id
    private String id;

    private String cedula;

    private String nombres;

    private String apellidos;

    private LocalDateTime nacimiento;

    private String direccion;

    private String telefono;

    private String correo;

    private List<Cuenta> cuentas;

    @Version
    private Long version;
}

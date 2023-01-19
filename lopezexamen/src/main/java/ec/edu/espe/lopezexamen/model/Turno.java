package ec.edu.espe.lopezexamen.model;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Version;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Builder
@Data
@Document(collection = "turnos")
public class Turno {

    @Id
    private String id;

    private String numero;

    private String cedulaCliente;

    private String nombreCliente;

    private String codigoEjecutivo;

    private String nombreEjecutivo;

    private LocalDateTime fechaGeneracion;

    private LocalDateTime fechaInicioAtencion;

    private LocalDateTime fechaFinAtencion;

    private Integer calificacion;

    @Version
    private Long version;
}

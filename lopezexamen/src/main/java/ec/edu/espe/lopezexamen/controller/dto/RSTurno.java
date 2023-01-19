package ec.edu.espe.lopezexamen.controller.dto;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class RSTurno {

    private Integer numero;

    private LocalDateTime fechaGeneracion;

    private String nombreCliente;

    private String nombreEjecutivo;

}

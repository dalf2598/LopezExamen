package ec.edu.espe.lopezexamen.controller.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RQTurnoInicioAtencion {

    private Integer numeroTurno;

    private String codigoEjecutivo;
}

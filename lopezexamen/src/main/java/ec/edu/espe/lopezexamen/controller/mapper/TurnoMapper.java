package ec.edu.espe.lopezexamen.controller.mapper;

import ec.edu.espe.lopezexamen.controller.dto.RQTurno;
import ec.edu.espe.lopezexamen.model.Turno;

public class TurnoMapper {

    public static Turno map(RQTurno rqTurno){

        return Turno.builder()
                .cedulaCliente(rqTurno.getCedulaCliente())
                .nombreCliente(rqTurno.getNombreCliente())
                .build();
    }
}

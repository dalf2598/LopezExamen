package ec.edu.espe.lopezexamen.controller.mapper;

import ec.edu.espe.lopezexamen.controller.dto.RQTurnoPrimero;
import ec.edu.espe.lopezexamen.controller.dto.RQTurnoSegundo;
import ec.edu.espe.lopezexamen.model.Turno;

public class TurnoMapper {

    public static Turno map(RQTurnoPrimero rqTurnoPrimero){

        return Turno.builder()
                .cedulaCliente(rqTurnoPrimero.getCedulaCliente())
                .nombreCliente(rqTurnoPrimero.getNombreCliente())
                .build();
    }

}

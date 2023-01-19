package ec.edu.espe.lopezexamen.controller.mapper;

import ec.edu.espe.lopezexamen.controller.dto.RQTurnoCreacion;
import ec.edu.espe.lopezexamen.model.Turno;

public class TurnoMapper {

    public static Turno map(RQTurnoCreacion rqTurnoCreacion){

        return Turno.builder()
                .cedulaCliente(rqTurnoCreacion.getCedulaCliente())
                .nombreCliente(rqTurnoCreacion.getNombreCliente())
                .build();
    }

}

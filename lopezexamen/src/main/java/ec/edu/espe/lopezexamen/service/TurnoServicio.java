package ec.edu.espe.lopezexamen.service;

import ec.edu.espe.lopezexamen.model.Turno;
import ec.edu.espe.lopezexamen.repository.TurnoRepositorio;
import ec.edu.espe.lopezexamen.utils.Utils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class TurnoServicio {

    private final TurnoRepositorio turnoRepositorio;

    public TurnoServicio(TurnoRepositorio turnoRepositorio){
        this.turnoRepositorio = turnoRepositorio;
    }

    public Turno crearTurno(Turno turno){
        List<Turno> turnos = turnoRepositorio.findAll();

        turno.setNumero(turnos.size() + 1);
        turno.setFechaGeneracion(Utils.currentDate());

        return turno;
    }
}

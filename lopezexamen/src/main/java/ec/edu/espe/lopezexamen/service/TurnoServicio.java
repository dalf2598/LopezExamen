package ec.edu.espe.lopezexamen.service;

import ec.edu.espe.lopezexamen.exception.RSRuntimeException;
import ec.edu.espe.lopezexamen.model.Ejecutivo;
import ec.edu.espe.lopezexamen.model.Turno;
import ec.edu.espe.lopezexamen.repository.EjecutivoRepositorio;
import ec.edu.espe.lopezexamen.repository.TurnoRepositorio;
import ec.edu.espe.lopezexamen.utils.Messages;
import ec.edu.espe.lopezexamen.utils.RSCode;
import ec.edu.espe.lopezexamen.utils.Utils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.mongodb.core.aggregation.ArrayOperators;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class TurnoServicio {

    private final TurnoRepositorio turnoRepositorio;
    private final EjecutivoRepositorio ejecutivoRepositorio;

    public TurnoServicio(TurnoRepositorio turnoRepositorio, EjecutivoRepositorio ejecutivoRepositorio){
        this.turnoRepositorio = turnoRepositorio;
        this.ejecutivoRepositorio = ejecutivoRepositorio;
    }

    public Turno generarTurno(Turno turno){
        List<Turno> turnos = turnoRepositorio.findAll();

        turno.setNumero(turnos.size() + 1);
        turno.setFechaGeneracion(Utils.currentDate());

        try{
            this.turnoRepositorio.save(turno);
        } catch (Exception e){
            throw new RSRuntimeException(Messages.TURN_NOT_CREATED, RSCode.INTERNAL_SERVER_ERROR);
        }

        return turno;
    }

    public Turno inicioAtencion(Integer numero, String codigoEjecutivo){

        Optional<Turno> opTurno = turnoRepositorio.findByNumero(numero);
        Optional<Ejecutivo> opEjecutivo = ejecutivoRepositorio.findByCodigoUsuario(codigoEjecutivo);

        if(!opTurno.isPresent()){
            throw new RSRuntimeException("No se encontro numero de turno", RSCode.NOT_FOUND);
        }

        if(!opEjecutivo.isPresent()){
            throw new RSRuntimeException("No se encontro ejecutivo con ese codigo", RSCode.NOT_FOUND);
        }

        Turno turno = opTurno.get();
        Ejecutivo ejecutivo = opEjecutivo.get();

        turno.setCodigoEjecutivo(codigoEjecutivo);
        turno.setNombreEjecutivo(ejecutivo.getNombreCompleto());
        turno.setFechaInicioAtencion(Utils.currentDate());


        try{
            this.turnoRepositorio.save(turno);
        } catch (Exception e){
            throw new RSRuntimeException(Messages.TURN_NOT_UPDATED, RSCode.INTERNAL_SERVER_ERROR);
        }

        return turno;
    }

    public Turno finAtencion(Integer numero){
        Optional<Turno> opTurno = turnoRepositorio.findByNumero(numero);
        if(!opTurno.isPresent()){
            throw new RSRuntimeException("No se encontro numero de turno", RSCode.NOT_FOUND);
        }

        Turno turno = opTurno.get();
        turno.setFechaFinAtencion(Utils.currentDate());

        try{
            this.turnoRepositorio.save(turno);
        } catch (Exception e){
            throw new RSRuntimeException(Messages.TURN_NOT_UPDATED, RSCode.INTERNAL_SERVER_ERROR);
        }

        return turno;
    }


    public Turno calificacion(Integer numero, Integer calificacion){
        Optional<Turno> opTurno = turnoRepositorio.findByNumero(numero);
        if(!opTurno.isPresent()){
            throw new RSRuntimeException("No se encontro numero de turno", RSCode.NOT_FOUND);
        }

        Turno turno = opTurno.get();
        turno.setCalificacion(calificacion);

        try{
            this.turnoRepositorio.save(turno);
        } catch (Exception e){
            throw new RSRuntimeException(Messages.TURN_NOT_UPDATED, RSCode.INTERNAL_SERVER_ERROR);
        }

        return turno;
    }
}

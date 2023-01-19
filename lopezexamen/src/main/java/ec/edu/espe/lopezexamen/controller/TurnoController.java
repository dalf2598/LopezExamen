package ec.edu.espe.lopezexamen.controller;

import ec.edu.espe.lopezexamen.controller.dto.RQTurnoPrimero;
import ec.edu.espe.lopezexamen.controller.dto.RQTurnoSegundo;
import ec.edu.espe.lopezexamen.controller.mapper.TurnoMapper;
import ec.edu.espe.lopezexamen.exception.RSRuntimeException;
import ec.edu.espe.lopezexamen.model.Turno;
import ec.edu.espe.lopezexamen.service.TurnoServicio;
import ec.edu.espe.lopezexamen.utils.Messages;
import ec.edu.espe.lopezexamen.utils.RSCode;
import ec.edu.espe.lopezexamen.utils.RSFormat;
import ec.edu.espe.lopezexamen.utils.Utils;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/atencion/turno")
public class TurnoController {

    private final TurnoServicio turnoServicio;

    public TurnoController(TurnoServicio turnoServicio){
        this.turnoServicio = turnoServicio;
    }

    @PostMapping
    public ResponseEntity<RSFormat> primeroCrearTurno(@RequestBody RQTurnoPrimero rqTurnoPrimero){
        try {
            if (!Utils.hasAllAttributes(rqTurnoPrimero)) {
                return ResponseEntity.status(RSCode.BAD_REQUEST.code)
                        .body(RSFormat.builder().message("Failure").data(Messages.MISSING_PARAMS).build());
            }

            Turno turno = turnoServicio.primeroCrearTurno(TurnoMapper.map(rqTurnoPrimero));

            return ResponseEntity.status(RSCode.SUCCESS.code)
                    .body(RSFormat.builder().message("Success").data(turno).build());

        }catch(RSRuntimeException e){
            return ResponseEntity.status(e.getCode())
                    .body(RSFormat.builder().message("Failure").data(e.getMessage()).build());

        } catch (Exception e){
            return ResponseEntity.status(500)
                    .body(RSFormat.builder().message("Failure").data(e.getMessage()).build());
        }

    }

    @PutMapping
    public ResponseEntity<RSFormat> segundoCrearTurno(@RequestBody RQTurnoSegundo rqTurnoSegundo){
        try {
            if (!Utils.hasAllAttributes(rqTurnoSegundo)) {
                return ResponseEntity.status(RSCode.BAD_REQUEST.code)
                        .body(RSFormat.builder().message("Failure").data(Messages.MISSING_PARAMS).build());
            }

            Turno turno = turnoServicio.segundoCrearTurno(rqTurnoSegundo.getNumeroTurno(), rqTurnoSegundo.getCodigoEjecutivo());

            return ResponseEntity.status(RSCode.SUCCESS.code)
                    .body(RSFormat.builder().message("Success").data(turno).build());

        }catch(RSRuntimeException e){
            return ResponseEntity.status(e.getCode())
                    .body(RSFormat.builder().message("Failure").data(e.getMessage()).build());

        } catch (Exception e){
            return ResponseEntity.status(500)
                    .body(RSFormat.builder().message("Failure").data(e.getMessage()).build());
        }

    }
}

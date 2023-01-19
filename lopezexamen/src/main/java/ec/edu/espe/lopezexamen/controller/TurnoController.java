package ec.edu.espe.lopezexamen.controller;

import ec.edu.espe.lopezexamen.controller.dto.RQTurnoCreacion;
import ec.edu.espe.lopezexamen.controller.dto.RQTurnoInicioAtencion;
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
    public ResponseEntity<RSFormat> generarTurno(@RequestBody RQTurnoCreacion rqTurnoCreacion){
        try {
            if (!Utils.hasAllAttributes(rqTurnoCreacion)) {
                return ResponseEntity.status(RSCode.BAD_REQUEST.code)
                        .body(RSFormat.builder().message("Failure").data(Messages.MISSING_PARAMS).build());
            }

            Turno turno = turnoServicio.generarTurno(TurnoMapper.map(rqTurnoCreacion));

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
    public ResponseEntity<RSFormat> inicioAtencion(@RequestBody RQTurnoInicioAtencion rqTurnoInicioAtencion){
        try {
            if (!Utils.hasAllAttributes(rqTurnoInicioAtencion)) {
                return ResponseEntity.status(RSCode.BAD_REQUEST.code)
                        .body(RSFormat.builder().message("Failure").data(Messages.MISSING_PARAMS).build());
            }

            Turno turno = turnoServicio.inicioAtencion(rqTurnoInicioAtencion.getNumeroTurno(), rqTurnoInicioAtencion.getCodigoEjecutivo());

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

    @GetMapping(value = "/{numero}")
    public ResponseEntity<RSFormat> finAtencion(@PathVariable("numero") Integer numero){
        try {
            if (Utils.isNullEmpty(numero)) {
                return ResponseEntity.status(RSCode.BAD_REQUEST.code)
                        .body(RSFormat.builder().message("Failure").data(Messages.MISSING_PARAMS).build());
            }

            Turno turno = turnoServicio.finAtencion(numero);

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

    @GetMapping(value = "/{numero}/cliente/{cedula}/calificacion/{calificacion}")
    public ResponseEntity<RSFormat> calificacion(@PathVariable("numero") Integer numero,
                                                 @PathVariable("cedula") String cedula,
                                                 @PathVariable("calificacion") Integer calificacion){
        try {
            if (Utils.isNullEmpty(numero)||Utils.isNullEmpty(cedula)||Utils.isNullEmpty(calificacion)) {
                return ResponseEntity.status(RSCode.BAD_REQUEST.code)
                        .body(RSFormat.builder().message("Failure").data(Messages.MISSING_PARAMS).build());
            }

            Turno turno = turnoServicio.calificacion(numero, calificacion);

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

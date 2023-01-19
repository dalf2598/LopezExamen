package ec.edu.espe.lopezexamen.controller;

import ch.qos.logback.core.net.server.Client;
import ec.edu.espe.lopezexamen.controller.mapper.ClienteMapper;
import ec.edu.espe.lopezexamen.exception.RSRuntimeException;
import ec.edu.espe.lopezexamen.model.Cliente;
import ec.edu.espe.lopezexamen.service.ClienteServicio;
import ec.edu.espe.lopezexamen.utils.Messages;
import ec.edu.espe.lopezexamen.utils.RSCode;
import ec.edu.espe.lopezexamen.utils.RSFormat;
import ec.edu.espe.lopezexamen.utils.Utils;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/atencion")
public class ClienteController {

    private final ClienteServicio clienteServicio;

    public ClienteController(ClienteServicio clienteServicio){
        this.clienteServicio = clienteServicio;
    }


    @GetMapping(value = "/{cedula}")
    public ResponseEntity<RSFormat> datosCliente(@PathVariable("cedula") String cedula){
        try {
            if (Utils.isNullEmpty(cedula)) {
                return ResponseEntity.status(RSCode.BAD_REQUEST.code)
                        .body(RSFormat.builder().message("Failure").data(Messages.MISSING_PARAMS).build());
            }

            Cliente cliente = clienteServicio.obtenerDatosCliente(cedula);

            return ResponseEntity.status(RSCode.SUCCESS.code)
                    .body(RSFormat.builder().message("Success").data(ClienteMapper.map(cliente)).build());

        }catch(RSRuntimeException e){
            return ResponseEntity.status(e.getCode())
                    .body(RSFormat.builder().message("Failure").data(e.getMessage()).build());

        } catch (Exception e){
            return ResponseEntity.status(500)
                    .body(RSFormat.builder().message("Failure").data(e.getMessage()).build());
        }

    }
}

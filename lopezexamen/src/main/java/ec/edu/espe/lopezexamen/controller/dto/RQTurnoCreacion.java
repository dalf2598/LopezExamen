package ec.edu.espe.lopezexamen.controller.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RQTurnoCreacion implements Serializable {

    private String cedulaCliente;

    private String nombreCliente;

}

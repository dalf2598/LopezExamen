package ec.edu.espe.lopezexamen.controller.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class RSCliente {

    private String cedula;

    private String nombres;

    private String apellidos;

}

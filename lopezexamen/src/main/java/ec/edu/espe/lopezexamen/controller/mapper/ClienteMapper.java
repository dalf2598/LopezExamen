package ec.edu.espe.lopezexamen.controller.mapper;

import ec.edu.espe.lopezexamen.controller.dto.RSCliente;
import ec.edu.espe.lopezexamen.model.Cliente;

public class ClienteMapper {

    public static RSCliente map(Cliente cliente){
        return RSCliente.builder()
                .cedula(cliente.getCedula())
                .nombres(cliente.getNombres())
                .apellidos(cliente.getApellidos())
                .build();
    }
}

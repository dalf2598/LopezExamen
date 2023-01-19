package ec.edu.espe.lopezexamen.service;

import ec.edu.espe.lopezexamen.exception.RSRuntimeException;
import ec.edu.espe.lopezexamen.model.Cliente;
import ec.edu.espe.lopezexamen.repository.ClienteRepositorio;
import ec.edu.espe.lopezexamen.utils.Messages;
import ec.edu.espe.lopezexamen.utils.RSCode;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Slf4j
@Service
public class ClienteServicio {
    private final ClienteRepositorio clienteRepositorio;

    public ClienteServicio(ClienteRepositorio clienteRepositorio){
        this.clienteRepositorio = clienteRepositorio;
    }

    public Cliente obtenerDatosCliente(String cedula){
        Optional<Cliente> opCliente = clienteRepositorio.findByCedula(cedula);

        if(!opCliente.isPresent()){
            throw new RSRuntimeException(Messages.ACCOUNTS_NOT_FOUND_FOR_CLIENT, RSCode.NOT_FOUND);
        }

        return opCliente.get();
    }
}

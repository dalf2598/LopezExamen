package ec.edu.espe.lopezexamen.model;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Builder
public class Cuenta {

    private String numero;

    private String tipo;

    private BigDecimal saldo;
}

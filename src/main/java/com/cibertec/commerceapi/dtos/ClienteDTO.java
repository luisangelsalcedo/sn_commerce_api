package com.cibertec.commerceapi.dtos;

import com.cibertec.commerceapi.model.TipoDocIdentidad;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class ClienteDTO {
    private Long idCliente;
    private LocalDate fecNacimiento;
    private String numDocIdentidad;
    private Long idUsuario; // dato de microservicio externo
    private TipoDocIdentidad tipoDocIdentidad;
}

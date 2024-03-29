package com.cibertec.commerceapi.dtos;

import com.cibertec.commerceapi.model.TipoDocIdentidad;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class ClienteCreateDTO {
    private Date fecNacimiento;
    private String numDocIdentidad;
    private Long idUsuario; // dato de microservicio externo
    private TipoDocIdentidad tipoDocIdentidad;
}

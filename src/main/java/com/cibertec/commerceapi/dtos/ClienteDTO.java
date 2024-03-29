package com.cibertec.commerceapi.dtos;

import com.cibertec.commerceapi.model.TipoDocIdentidad;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class ClienteDTO {
    private Long idCliente;
    private Date fecNacimiento;
    private String numDocIdentidad;
    private Long idUsuario;
    private UsuarioDTO usuario; // dato de microservicio externo
    private TipoDocIdentidad tipoDocIdentidad;
}

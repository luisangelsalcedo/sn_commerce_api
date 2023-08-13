package com.cibertec.commerceapi.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProveedorDTO {
    private Long idProveedor;
    private String ruc;
    private String nombre;
    private String contacto;
    private String email;
    private String celular ;
    private String estado;
}

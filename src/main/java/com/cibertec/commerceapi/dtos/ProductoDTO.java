package com.cibertec.commerceapi.dtos;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class ProductoDTO {
    private Long idProducto ;
    private String nombre;
    private String imagen;
    private String descripcion;
    private BigDecimal precioUnitario;
    private Integer stock;
    private CategoriaProductoDTO categoriaProducto;
    private ProveedorDTO proveedor;
}

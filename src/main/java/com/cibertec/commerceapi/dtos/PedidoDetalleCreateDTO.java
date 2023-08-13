package com.cibertec.commerceapi.dtos;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class PedidoDetalleCreateDTO {
    private Long cantidad;
    private BigDecimal montoSubtotalProducto;
    private Long idProducto;
    private Long idPedido;
}

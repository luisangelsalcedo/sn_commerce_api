package com.cibertec.commerceapi.dtos;

import com.cibertec.commerceapi.model.Cliente;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Getter
@Setter
public class PedidoDTO {
    private Long idPedido;
    private Date fecPedido;
    private BigDecimal montoSubtotal;
    private BigDecimal montoTotal;
    private ClienteDTO cliente;
    private List<PedidoDetalleDTO> pedidoDetalle;
}
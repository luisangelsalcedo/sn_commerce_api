package com.cibertec.commerceapi.dtos;

import com.cibertec.commerceapi.model.Cliente;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
public class PedidoDTO {
    private Long idPedido;
    private LocalDate fecPedido;
    private BigDecimal montoSubtotal;
    private BigDecimal montoTotal;
    private Cliente cliente;
    private List<PedidoDetalleDTO> pedidoDetalle;
}
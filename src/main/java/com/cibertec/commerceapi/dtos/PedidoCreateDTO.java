package com.cibertec.commerceapi.dtos;

import com.cibertec.commerceapi.model.PedidoDetalle;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
public class PedidoCreateDTO {
    private LocalDate fecPedido;
    private BigDecimal montoSubtotal;
    private BigDecimal montoTotal;
    private Long idCliente;
    private List<PedidoDetalle> pedidoDetalle;
}
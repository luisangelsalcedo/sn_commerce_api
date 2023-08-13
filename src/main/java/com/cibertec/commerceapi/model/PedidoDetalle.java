package com.cibertec.commerceapi.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "tb_pedido_detalle")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PedidoDetalle {

    @Id
    @Column(name = "id_pedido_detalle", nullable = false)
    private Long idPedidoDetalle;

    @Column(name = "cantidad", nullable = false)
    private Long cantidad;

    @Column(name = "monto_subtotal_producto", precision = 10, scale = 2, nullable = false)
    private BigDecimal montoSubtotalProducto;

    @Column(name = "id_producto", nullable = false)
    private Long idProducto;

    @Column(name="id_pedido")
    private Long idPedido;
}

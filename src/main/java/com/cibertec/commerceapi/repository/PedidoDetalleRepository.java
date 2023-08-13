package com.cibertec.commerceapi.repository;

import com.cibertec.commerceapi.model.PedidoDetalle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PedidoDetalleRepository extends JpaRepository<PedidoDetalle, Long> {
    public List<PedidoDetalle> getPedidoDetalleByIdPedido(Long id);
}

package com.cibertec.commerceapi.service;

import com.cibertec.commerceapi.dtos.PedidoCreateDTO;
import com.cibertec.commerceapi.dtos.PedidoDTO;

import java.util.List;

public interface PedidoService {
    List<PedidoDTO> listarPedidos();
    PedidoDTO obtenerPedidoPorID(long id);
    PedidoDTO registrarPedido(PedidoCreateDTO pedidoCreateDTO);
}

package com.cibertec.commerceapi.service;

import com.cibertec.commerceapi.dtos.PedidoCreateDTO;
import com.cibertec.commerceapi.dtos.PedidoDTO;
import com.cibertec.commerceapi.dtos.PedidoDetalleCreateDTO;
import com.cibertec.commerceapi.dtos.PedidoDetalleDTO;
import com.cibertec.commerceapi.mappers.PedidoDetalleMapper;
import com.cibertec.commerceapi.mappers.PedidoMapper;
import com.cibertec.commerceapi.model.Pedido;
import com.cibertec.commerceapi.model.PedidoDetalle;
import com.cibertec.commerceapi.repository.PedidoDetalleRepository;
import com.cibertec.commerceapi.repository.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PedidoServiceImpl implements PedidoService{

    @Autowired
    private PedidoRepository pedidoRepository;

    @Autowired
    private PedidoDetalleRepository pedidoDetalleRepository;

    @Override
    public List<PedidoDTO> listarPedidos() {
        List<PedidoDTO> lista = PedidoMapper.instancia.listaPedidoAListaPedidoDTO(pedidoRepository.findAll());
        return lista;
    }

    @Override
    public PedidoDTO obtenerPedidoPorID(long id) {
        Optional<Pedido> pedido = pedidoRepository.findById(id);
        PedidoDTO pedidoDTO = null;
        if ( pedido.isPresent() ){
            pedidoDTO = PedidoMapper.instancia.pedidoAPedidoDTO(pedido.get());
        }
        return pedidoDTO;
    }

    @Override
    public PedidoDTO registrarPedido(PedidoCreateDTO pedidoCreateDTO) {

        Pedido pedido= PedidoMapper.instancia.pedidoCreateDTOAPedido(pedidoCreateDTO);
        Pedido respuestaEntity= pedidoRepository.save(pedido);

        PedidoDTO respuestaDTO = PedidoMapper.instancia.pedidoAPedidoDTO(pedidoRepository.findById(respuestaEntity.getIdPedido()).orElse(null));

        return respuestaDTO;
    }
}

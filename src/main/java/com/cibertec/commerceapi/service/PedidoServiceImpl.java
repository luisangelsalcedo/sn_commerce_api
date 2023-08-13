package com.cibertec.commerceapi.service;

import com.cibertec.commerceapi.dtos.PedidoCreateDTO;
import com.cibertec.commerceapi.dtos.PedidoDTO;
import com.cibertec.commerceapi.dtos.PedidoDetalleDTO;
import com.cibertec.commerceapi.dtos.ProductoDTO;
import com.cibertec.commerceapi.feign.PedidoDetalleFeignProducto;
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
public class PedidoServiceImpl implements PedidoService {

    @Autowired
    private PedidoRepository pedidoRepository;

    @Autowired
    private PedidoDetalleRepository pedidoDetalleRepository;

    @Autowired
    private PedidoDetalleFeignProducto pedidoDetalleFeignProducto;

    @Autowired
    private ClienteService clienteService;

    @Override
    public List<PedidoDTO> listarPedidos() {
        List<PedidoDTO> lista = PedidoMapper.instancia.listaPedidoAListaPedidoDTO(pedidoRepository.findAll());
        lista.forEach(this::inyectarProductosEnPedido);
        return lista;
    }

    @Override
    public PedidoDTO obtenerPedidoPorID(long id) {
        Optional<Pedido> pedido = pedidoRepository.findById(id);
        PedidoDTO pedidoDTO = null;
        if (pedido.isPresent()) {
            pedidoDTO = PedidoMapper.instancia.pedidoAPedidoDTO(pedido.get());
            inyectarProductosEnPedido(pedidoDTO);
        }
        return pedidoDTO;
    }

    @Override
    public PedidoDTO registrarPedido(PedidoCreateDTO pedidoCreateDTO) {
        Pedido pedido = PedidoMapper.instancia.pedidoCreateDTOAPedido(pedidoCreateDTO);
        Pedido respuestaEntity = pedidoRepository.save(pedido);
        Long idPedido = respuestaEntity.getIdPedido();
        agregarDetallePedido(idPedido, pedido.getPedidoDetalle());
        PedidoDTO respuestaDTO = PedidoMapper.instancia.pedidoAPedidoDTO(respuestaEntity);
        return respuestaDTO;
    }

    ////////////////////////////////////////////////////////////////////

    private void inyectarProductosEnPedido(PedidoDTO pedidoDTO) {
        List<PedidoDetalleDTO> pedidoDetalleDTOList = pedidoDTO.getPedidoDetalle();
        for (PedidoDetalleDTO pedidoDetalleDTO : pedidoDetalleDTOList) {
            Long idProducto = pedidoDetalleDTO.getIdProducto();
            ProductoDTO productoDTO = pedidoDetalleFeignProducto.obtenerProductoPorId(idProducto);
            pedidoDetalleDTO.setProducto(productoDTO);

            clienteService.inyectarUsuariosEnCliente(pedidoDTO.getCliente());
        }
    }

    private void agregarDetallePedido(Long idPedido, List<PedidoDetalle> pedidoDetalleList) {
        for (PedidoDetalle detalle : pedidoDetalleList) {
            detalle.setIdPedido(idPedido);
            pedidoDetalleRepository.save(detalle);
        }
    }
}
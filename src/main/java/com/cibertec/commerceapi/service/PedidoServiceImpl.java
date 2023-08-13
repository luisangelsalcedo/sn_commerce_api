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

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@Service
public class PedidoServiceImpl implements PedidoService{

    private static final Logger logger = LoggerFactory.getLogger(PedidoServiceImpl.class);

    @Autowired
    private PedidoRepository pedidoRepository;

    @Autowired
    private PedidoDetalleRepository pedidoDetalleRepository;

    @Autowired
    private PedidoDetalleFeignProducto pedidoDetalleFeignProducto;

    @Override
    public List<PedidoDTO> listarPedidos() {
        List<PedidoDTO> lista = PedidoMapper.instancia.listaPedidoAListaPedidoDTO(pedidoRepository.findAll());

        for (PedidoDTO pedidoDTO : lista){
            // obtengo todos los detallePedido en una lista
            List<PedidoDetalleDTO> pedidoDetalleDTOList = pedidoDTO.getPedidoDetalle();

            // recorro la lista
            for (PedidoDetalleDTO pedidoDetalleDTO : pedidoDetalleDTOList){

                // obtengo el id del producto de cada item
                Long idProducto = pedidoDetalleDTO.getIdProducto();

                // obtengo el producto con su id usando feign
                ProductoDTO productoDTO = pedidoDetalleFeignProducto.obtenerProductoPorId(idProducto);

                // inyecto el producto en pedidoDetalle
                pedidoDetalleDTO.setProducto(productoDTO);
            }
        }

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

        Pedido pedido = PedidoMapper.instancia.pedidoCreateDTOAPedido(pedidoCreateDTO);
        Pedido respuestaEntity = pedidoRepository.save(pedido);

        Long idPedido = respuestaEntity.getIdPedido();
        logger.debug(idPedido.toString());

        // Añadir DetallePedido en el pedido
        List<PedidoDetalle> pedidoDetalleList = pedido.getPedidoDetalle();
        for(PedidoDetalle detalle : pedidoDetalleList){

            detalle.setIdPedido(idPedido);
            pedidoDetalleRepository.save(detalle);
        }
        //

        PedidoDTO respuestaDTO = PedidoMapper.instancia.pedidoAPedidoDTO(respuestaEntity);
        return respuestaDTO;
    }
}

package com.cibertec.commerceapi.mappers;

import com.cibertec.commerceapi.dtos.PedidoCreateDTO;
import com.cibertec.commerceapi.dtos.PedidoDTO;
import com.cibertec.commerceapi.model.Pedido;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface PedidoMapper {
    PedidoMapper instancia = Mappers.getMapper(PedidoMapper.class);


    PedidoDTO pedidoAPedidoDTO(Pedido pedido);
    @Mapping(target = "cliente.idCliente", source = "idCliente")
    Pedido pedidoCreateDTOAPedido(PedidoCreateDTO pedidoCreateDTO);
    List<PedidoDTO> listaPedidoAListaPedidoDTO(List<Pedido> listaPedido);
}

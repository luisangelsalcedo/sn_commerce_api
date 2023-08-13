package com.cibertec.commerceapi.mappers;

import com.cibertec.commerceapi.dtos.PedidoDetalleCreateDTO;
import com.cibertec.commerceapi.dtos.PedidoDetalleDTO;
import com.cibertec.commerceapi.model.PedidoDetalle;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface PedidoDetalleMapper {
    PedidoDetalleMapper instancia = Mappers.getMapper(PedidoDetalleMapper.class);


    PedidoDetalle pedidoDetalleCreateDTOAPedidoDetalle(PedidoDetalleCreateDTO pedidoDetalleCreateDTO);
    List<PedidoDetalleDTO> listaPedidoDetalleAListaPedidoDetalleDTO (List<PedidoDetalle> listaPedidoDetalle);
}

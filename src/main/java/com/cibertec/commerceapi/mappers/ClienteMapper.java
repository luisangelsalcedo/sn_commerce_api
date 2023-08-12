package com.cibertec.commerceapi.mappers;

import com.cibertec.commerceapi.dtos.ClienteCreateDTO;
import com.cibertec.commerceapi.dtos.ClienteDTO;
import com.cibertec.commerceapi.dtos.ClienteUpdateDTO;
import com.cibertec.commerceapi.model.Cliente;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface ClienteMapper {
    ClienteMapper instancia = Mappers.getMapper(ClienteMapper.class);


    ClienteDTO clienteAClienteDTO(Cliente cliente);
    Cliente clienteDTOACliente(ClienteDTO clienteDTO);
    Cliente clienteCreateDTOACliente(ClienteCreateDTO clienteCreateDTO);
    Cliente clienteUpdateDTOACliente(ClienteUpdateDTO clienteUpdateDTO);
    List<ClienteDTO> listaClienteAListaClienteDTO(List<Cliente> listaClientes);
}

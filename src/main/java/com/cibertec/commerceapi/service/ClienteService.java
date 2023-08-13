package com.cibertec.commerceapi.service;

import com.cibertec.commerceapi.dtos.ClienteCreateDTO;
import com.cibertec.commerceapi.dtos.ClienteDTO;
import com.cibertec.commerceapi.dtos.ClienteUpdateDTO;

import java.util.List;

public interface ClienteService {
    List<ClienteDTO> listarClientes();
    ClienteDTO obtenerClientePorID(long id);
    ClienteDTO registrarCliente(ClienteCreateDTO clienteCreateDTO);
    ClienteDTO actualizarCliente(ClienteUpdateDTO clienteUpdateDTO);
    String eliminarCliente(long id);

    void inyectarUsuariosEnCliente(ClienteDTO clienteDTO);
}

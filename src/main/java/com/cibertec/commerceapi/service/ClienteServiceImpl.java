package com.cibertec.commerceapi.service;

import com.cibertec.commerceapi.dtos.ClienteCreateDTO;
import com.cibertec.commerceapi.dtos.ClienteDTO;
import com.cibertec.commerceapi.dtos.ClienteUpdateDTO;
import com.cibertec.commerceapi.dtos.UsuarioDTO;
import com.cibertec.commerceapi.feign.ClienteFeignUsuario;
import com.cibertec.commerceapi.mappers.ClienteMapper;
import com.cibertec.commerceapi.model.Cliente;
import com.cibertec.commerceapi.model.TipoDocIdentidad;
import com.cibertec.commerceapi.repository.ClienteRepository;
import com.cibertec.commerceapi.repository.TipoDocIdentidadRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;

@Service
public class ClienteServiceImpl implements ClienteService{

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private TipoDocIdentidadRepository tipoDocIdentidadRepository;

    @Autowired
    private ClienteFeignUsuario clienteFeignUsuario ;

    @Override
    public List<ClienteDTO> listarClientes() {
        List<ClienteDTO> lista = ClienteMapper.instancia.listaClienteAListaClienteDTO(clienteRepository.findAll());
        lista.forEach(this::inyectarUsuariosEnCliente);
        return lista;
    }

    @Override
    public ClienteDTO obtenerClientePorID(long id) {
        Optional<Cliente> clienteOptional = clienteRepository.findById(id);
        ClienteDTO clienteDTO = null;
        if(clienteOptional.isPresent()){
            Cliente cliente = clienteOptional.get();
            clienteDTO = ClienteMapper.instancia.clienteAClienteDTO(cliente);

            inyectarUsuariosEnCliente(clienteDTO);
        }
        return clienteDTO;
    }

    @Override
    public ClienteDTO registrarCliente(ClienteCreateDTO clienteCreateDTO) {
        Cliente cliente = ClienteMapper.instancia.clienteCreateDTOACliente(clienteCreateDTO);

        // Añadir tipoDocIdentidad en cliente
        TipoDocIdentidad tipoDocIdentidad = tipoDocIdentidadRepository.findById(clienteCreateDTO.getTipoDocIdentidad().getIdTipoDocIdentidad())
                .orElseThrow(() -> new EntityNotFoundException("Tipo de documento no encontrado"));
        cliente.setTipoDocIdentidad(tipoDocIdentidad);
        //

        Cliente respuestaEntity = clienteRepository.save(cliente);
        ClienteDTO respuetaDTO = ClienteMapper.instancia.clienteAClienteDTO(respuestaEntity);
        return respuetaDTO;
    }

    @Override
    public ClienteDTO actualizarCliente(ClienteUpdateDTO clienteUpdateDTO) {
        Cliente cliente = ClienteMapper.instancia.clienteUpdateDTOACliente(clienteUpdateDTO);
        Cliente respuestaEntity = clienteRepository.save(cliente);
        ClienteDTO respuetaDTO = ClienteMapper.instancia.clienteAClienteDTO(respuestaEntity);
        return respuetaDTO;
    }

    @Override
    public String eliminarCliente(long id) {
        boolean clienteExistente = clienteRepository.existsById(id);
        String mensaje = "";
        if(clienteExistente){
            clienteRepository.deleteById(id);
            mensaje = "Registro eliminado";
        } else {
            mensaje = "No se pudo eliminar el registro";
        }
        return mensaje;
    }

    ////////////////////////////////////////////////////////////////////

    private void inyectarUsuariosEnCliente(ClienteDTO clienteDTO){
        Long idUsuario = clienteDTO.getIdUsuario();
        UsuarioDTO usuarioDTO = clienteFeignUsuario.obtenerUsuarioPorId(idUsuario);
        clienteDTO.setUsuario(usuarioDTO);
    }
}

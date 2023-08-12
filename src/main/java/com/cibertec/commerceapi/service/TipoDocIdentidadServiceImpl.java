package com.cibertec.commerceapi.service;

import com.cibertec.commerceapi.dtos.TipoDocIdentidadDTO;
import com.cibertec.commerceapi.dtos.TipoDocIdentidadCreateDTO;
import com.cibertec.commerceapi.dtos.TipoDocIdentidadUpdateDTO;
import com.cibertec.commerceapi.mappers.TipoDocIdentidadMapper;
import com.cibertec.commerceapi.model.TipoDocIdentidad;
import com.cibertec.commerceapi.repository.TipoDocIdentidadRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TipoDocIdentidadServiceImpl implements TipoDocIdentidadService{

    @Autowired
    private TipoDocIdentidadRepository tipoDocIdentidadRepository;

    @Override
    public List<TipoDocIdentidadDTO> listarTiposDocIdentidad() {
        return TipoDocIdentidadMapper.instancia.listaTipoDocIdentidadAListaTipoDocIdentidadDTO(tipoDocIdentidadRepository.findAll());
    }

    @Override
    public TipoDocIdentidadDTO obtenerTipoDocIdentidadPorID(long id) {
        Optional<TipoDocIdentidad> tipoDocIdentidadOptional = tipoDocIdentidadRepository.findById(id);
        TipoDocIdentidadDTO tipoDocIdentidadDTO = null;
        if(tipoDocIdentidadOptional.isPresent()){
            TipoDocIdentidad tipoDocIdentidad = tipoDocIdentidadOptional.get();
            tipoDocIdentidadDTO = TipoDocIdentidadMapper.instancia.tipoDocIdentidadATipoDocIdentidadDTO(tipoDocIdentidad);
        }
        return tipoDocIdentidadDTO;
    }

    @Override
    public TipoDocIdentidadDTO registrarTipoDocIdentidad(TipoDocIdentidadCreateDTO tipoDocIdentidadCreateDTO) {
        TipoDocIdentidad tipoDocIdentidad = TipoDocIdentidadMapper.instancia.tipoDocIdentidadCreateDTOATipoDocIdentidad(tipoDocIdentidadCreateDTO);
        TipoDocIdentidad respuestaEntity = tipoDocIdentidadRepository.save(tipoDocIdentidad);
        TipoDocIdentidadDTO respuetaDTO = TipoDocIdentidadMapper.instancia.tipoDocIdentidadATipoDocIdentidadDTO(respuestaEntity);
        return respuetaDTO;
    }

    @Override
    public TipoDocIdentidadDTO actualizarTipoDocIdentidad(TipoDocIdentidadUpdateDTO tipoDocIdentidadUpdateDTO) {
        TipoDocIdentidad tipoDocIdentidad = TipoDocIdentidadMapper.instancia.tipoDocIdentidadUpdateDTOATipoDocIdentidad(tipoDocIdentidadUpdateDTO);
        TipoDocIdentidad respuestaEntity = tipoDocIdentidadRepository.save(tipoDocIdentidad);
        TipoDocIdentidadDTO respuetaDTO = TipoDocIdentidadMapper.instancia.tipoDocIdentidadATipoDocIdentidadDTO(respuestaEntity);
        return respuetaDTO;
    }

    @Override
    public String eliminarTipoDocIdentidad(long id) {
        boolean tipoDocIdentidadExistente = tipoDocIdentidadRepository.existsById(id);
        String mensaje = "";
        if(tipoDocIdentidadExistente){
            tipoDocIdentidadRepository.deleteById(id);
            mensaje = "Registro eliminado";
        } else {
            mensaje = "No se pudo eliminar el registro";
        }
        return mensaje;
    }
}

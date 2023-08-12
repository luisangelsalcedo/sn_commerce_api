package com.cibertec.commerceapi.mappers;

import com.cibertec.commerceapi.dtos.TipoDocIdentidadCreateDTO;
import com.cibertec.commerceapi.dtos.TipoDocIdentidadDTO;
import com.cibertec.commerceapi.dtos.TipoDocIdentidadUpdateDTO;
import com.cibertec.commerceapi.model.TipoDocIdentidad;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface TipoDocIdentidadMapper {
    TipoDocIdentidadMapper instancia = Mappers.getMapper(TipoDocIdentidadMapper.class);


    TipoDocIdentidadDTO tipoDocIdentidadATipoDocIdentidadDTO(TipoDocIdentidad tipoDocIdentidad);
    TipoDocIdentidad tipoDocIdentidadDTOATipoDocIdentidad(TipoDocIdentidadDTO tipoDocIdentidadDTO);
    TipoDocIdentidad tipoDocIdentidadCreateDTOATipoDocIdentidad(TipoDocIdentidadCreateDTO tipoDocIdentidadCreateDTO);
    TipoDocIdentidad tipoDocIdentidadUpdateDTOATipoDocIdentidad(TipoDocIdentidadUpdateDTO tipoDocIdentidadUpdateDTO);
    List<TipoDocIdentidadDTO> listaTipoDocIdentidadAListaTipoDocIdentidadDTO(List<TipoDocIdentidad> listaTipoDocIdentidads);
}

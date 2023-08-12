package com.cibertec.commerceapi.service;

import com.cibertec.commerceapi.dtos.TipoDocIdentidadCreateDTO;
import com.cibertec.commerceapi.dtos.TipoDocIdentidadDTO;
import com.cibertec.commerceapi.dtos.TipoDocIdentidadUpdateDTO;

import java.util.List;

public interface TipoDocIdentidadService {
    List<TipoDocIdentidadDTO> listarTiposDocIdentidad();
    TipoDocIdentidadDTO obtenerTipoDocIdentidadPorID(long id);
    TipoDocIdentidadDTO registrarTipoDocIdentidad(TipoDocIdentidadCreateDTO tipoDocIdentidadCreateDTO);
    TipoDocIdentidadDTO actualizarTipoDocIdentidad(TipoDocIdentidadUpdateDTO tipoDocIdentidadUpdateDTO);
    String eliminarTipoDocIdentidad(long id);
}

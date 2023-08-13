package com.cibertec.commerceapi.feign;

import com.cibertec.commerceapi.config.FeignConfig;
import com.cibertec.commerceapi.dtos.UsuarioDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;



@FeignClient(name="usuario-api", url="http://localhost:8080/api/usuarios", configuration = FeignConfig.class)
public interface ClienteFeignUsuario {

    @GetMapping("/{idUsuario}")
    UsuarioDTO obtenerUsuarioPorId(@PathVariable("idUsuario") Long idUsuario);
}
package com.cibertec.commerceapi.feign;

import com.cibertec.commerceapi.config.FeignConfig;
import com.cibertec.commerceapi.dtos.ProductoDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name="producto-api", url="http://localhost:8082/api/productos", configuration = FeignConfig.class)
public interface PedidoDetalleFeignProducto {

    @GetMapping("/{idProducto}")
    ProductoDTO obtenerProductoPorId(@PathVariable("idProducto") Long idProducto);
}

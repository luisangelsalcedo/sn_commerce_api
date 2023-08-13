package com.cibertec.commerceapi.controller;

import com.cibertec.commerceapi.dtos.PedidoCreateDTO;
import com.cibertec.commerceapi.dtos.PedidoDTO;
import com.cibertec.commerceapi.service.PedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/pedidos")
public class PedidoController {
    @Autowired
    private PedidoService pedidoService;

    @GetMapping
    public ResponseEntity<List<PedidoDTO>> listarPedidos(){
        return new ResponseEntity<>(pedidoService.listarPedidos(), HttpStatus.OK);
    }

    @GetMapping("/{pedidoId}")
    public ResponseEntity<PedidoDTO> obtenerPedidoPorId(@PathVariable("pedidoId") long pedidoId) {
        return new ResponseEntity<>(pedidoService.obtenerPedidoPorID(pedidoId), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<PedidoDTO> registrarPedido(@RequestBody PedidoCreateDTO pedidoCreateDTO){
        return new ResponseEntity<>(pedidoService.registrarPedido(pedidoCreateDTO), HttpStatus.OK);
    }
}

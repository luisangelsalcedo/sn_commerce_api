package com.cibertec.commerceapi.controller;

import com.cibertec.commerceapi.dtos.TipoDocIdentidadCreateDTO;
import com.cibertec.commerceapi.dtos.TipoDocIdentidadDTO;
import com.cibertec.commerceapi.dtos.TipoDocIdentidadUpdateDTO;
import com.cibertec.commerceapi.service.TipoDocIdentidadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tipo-doc-identidad")
public class TipoDocIdentidadController {
    @Autowired
    private TipoDocIdentidadService tipoDocIdentidadService;

    @GetMapping
    public ResponseEntity<List<TipoDocIdentidadDTO>> listarTipoDocIdentidads(){
        return new ResponseEntity<>(tipoDocIdentidadService.listarTiposDocIdentidad(), HttpStatus.OK);
    }

    @GetMapping("/{tipoDocIdentidadId}")
    public ResponseEntity<TipoDocIdentidadDTO> obtenerTipoDocIdentidadPorId(@PathVariable("tipoDocIdentidadId") long tipoDocIdentidadId){
        return new ResponseEntity<>(tipoDocIdentidadService.obtenerTipoDocIdentidadPorID(tipoDocIdentidadId), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<TipoDocIdentidadDTO> registrarTipoDocIdentidad(@RequestBody TipoDocIdentidadCreateDTO tipoDocIdentidadCreateDTO){

        return new ResponseEntity<>(tipoDocIdentidadService.registrarTipoDocIdentidad(tipoDocIdentidadCreateDTO), HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<TipoDocIdentidadDTO> actualizarTipoDocIdentidad(@RequestBody TipoDocIdentidadUpdateDTO tipoDocIdentidadUpdateDTO){
        return new ResponseEntity<>(tipoDocIdentidadService.actualizarTipoDocIdentidad(tipoDocIdentidadUpdateDTO),HttpStatus.OK);
    }

    @DeleteMapping("/{tipoDocIdentidadId}")
    public ResponseEntity<String> eliminarTipoDocIdentidad(@PathVariable("tipoDocIdentidadId") long tipoDocIdentidadId){
        return new ResponseEntity<>(tipoDocIdentidadService.eliminarTipoDocIdentidad(tipoDocIdentidadId),HttpStatus.OK);
    }
}

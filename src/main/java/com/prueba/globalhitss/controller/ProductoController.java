package com.prueba.globalhitss.controller;

import com.prueba.globalhitss.model.Producto;
import com.prueba.globalhitss.service.ProductoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;
import java.util.List;

@RequestMapping("/producto")
@RestController
@RequiredArgsConstructor
public class ProductoController {

    private final ProductoService service;

    @PostMapping
    ResponseEntity<List<Producto>> registrarProducto(Producto producto) {
        var result = service.registrarProduto(producto);
        return ResponseEntity.created(URI.create("/")).body(result);
    }

}

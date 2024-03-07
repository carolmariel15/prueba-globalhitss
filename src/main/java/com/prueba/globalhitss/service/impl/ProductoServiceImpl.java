package com.prueba.globalhitss.service.impl;

import com.prueba.globalhitss.model.Producto;
import com.prueba.globalhitss.repository.ProductoRepository;
import com.prueba.globalhitss.service.ProductoService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductoServiceImpl implements ProductoService {

    private final ProductoRepository repository;

    @Override
    public List<Producto> registrarProduto(Producto producto) {
        if (repository.registrarProducto(producto) == true) {
            return repository.listarProductos();
        };
        return new ArrayList<>();
    }
}

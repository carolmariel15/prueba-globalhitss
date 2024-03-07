package com.prueba.globalhitss.repository;

import com.prueba.globalhitss.model.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProductoRepository extends JpaRepository<Producto, Integer> {

    @Query(value = "execute SP_REGISTRAR_PRODUCTO(:producto.id, :producto.nombre)", nativeQuery = true)
    boolean registrarProducto(Producto producto);

    @Query(value = "execute SP_LISTAR_PRODUCTOS()", nativeQuery = true)
    List<Producto> listarProductos();
}

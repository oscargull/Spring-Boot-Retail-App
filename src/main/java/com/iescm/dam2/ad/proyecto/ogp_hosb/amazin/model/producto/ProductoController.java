package com.iescm.dam2.ad.proyecto.ogp_hosb.amazin.model.producto;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/productos")
public class ProductoController{

    @Autowired
    private ProductoService service;

        @GetMapping
    public List<Producto> listaProductos(){
        return service.listarProductos();
    }


}
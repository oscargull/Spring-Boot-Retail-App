package com.iescm.dam2.ad.proyecto.ogp_hosb.amazin.model.producto;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping
public class ProductoControllerList {

    @Autowired
    private ProductoService service;
    
    @GetMapping("/productos")
    public String listarProductos(Model model){
        List<Producto> productos = service.listarProductos();
        model.addAttribute("productos", productos);
        return "listado_productos"; // Devuelve la plantilla "listado.html"
    }
}

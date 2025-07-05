package com.dam2.project.amazin.model.almacen;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping
public class AlmacenControllerList {

    @Autowired
    private AlmacenService service;
    
    @GetMapping("/almacenes")
    public String listarProductos(Model model){
        List<Almacen> almacenes = service.listarAlmacenes();
        model.addAttribute("almacenes", almacenes);
        return "listado_almacenes"; // Devuelve la plantilla "listado.html"
    }
}

package com.dam2.project.amazin.model.destino;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping
public class DestinoControllerList {
    @Autowired
    private DestinoService service;

    @GetMapping("/destinos")
    public String listarProductos(Model model){
        List<Destino> destinos = service.listarDestinos();
        model.addAttribute("destinos", destinos);
        return "listado_destinos"; // Devuelve la plantilla "listado.html"
    }

    @GetMapping("/creardestino")
    public String destinoAddForm(Model model){

//        List<Destino> destinos= destinoService.listarDestinos();
//        List<Producto> productos= productoService.listarProductos();
//        List<Almacen> almacenes = almacenService.listarAlmacenes();
//
       model.addAttribute("destino", new Destino());
//        model.addAttribute("almacenes", almacenes);
//        model.addAttribute("productos", productos);
//        model.addAttribute("destinos", destinos);
        return "fragments/modal_destino_add";
    }
}

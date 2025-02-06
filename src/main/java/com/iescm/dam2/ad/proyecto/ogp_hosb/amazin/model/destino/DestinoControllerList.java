package com.iescm.dam2.ad.proyecto.ogp_hosb.amazin.model.destino;

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
}

package com.iescm.dam2.ad.proyecto.ogp_hosb.amazin.model.destino;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.iescm.dam2.ad.proyecto.ogp_hosb.amazin.model.producto.Producto;

import java.util.List;

@Controller
@RequestMapping("/api/destinos")
public class DestinoController {
    @Autowired
    DestinoService destinoService;

    @GetMapping("/{id}")
    public ResponseEntity<Destino> getDestino(@PathVariable Long id) {
        Destino destino = destinoService.obtenerPorId(id).orElse(null);
        if (destino == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
        return ResponseEntity.ok(destino);
    }

    @GetMapping
    @ResponseBody
    public List<Destino> listarDestinos(){
        return destinoService.listarDestinos();
    }

    @GetMapping("/{id}/view")
    public String viewDestino(@PathVariable Long id, Model model) {
        Destino destino = destinoService.obtenerPorId(id).orElse(null);
        model.addAttribute("destino", destino);
        return "fragments/modal_destino";
    }

    @PostMapping("/{id}/delete")
    public String eliminarDestino(@PathVariable Long id, Model model){
        destinoService.eliminarDestino(id);
        List<Destino> destinos = destinoService.listarDestinos();
        model.addAttribute("destinos", destinos);
        return "listado_destinos";
    }


}

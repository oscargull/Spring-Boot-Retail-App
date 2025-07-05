package com.dam2.project.amazin.model.almacen;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/api/almacenes")
public class AlmacenController {

    @Autowired
    AlmacenService almacenService;

    @GetMapping("/{id}")
    public ResponseEntity<Almacen> getAlmacen(@PathVariable Long id) {
        Almacen almacen = almacenService.obtenerPorId(id).orElse(null);
        if (almacen == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
        return ResponseEntity.ok(almacen);
    }

    @GetMapping("/{id}/view")
    public String viewAlmacen(@PathVariable Long id, Model model) {
        Almacen almacen = almacenService.obtenerPorId(id).orElse(null);
        model.addAttribute("almacen", almacen);
        return "fragments/modal_almacen";
    }

    /*@PostMapping("/{id}/delete")
    public String eliminarAlmacen(@PathVariable Long id, Model model){
        almacenService.eliminarAlmacen(id);
        List<Almacen> almacenes = almacenService.listarAlmacenes();
        model.addAttribute("almacenes", almacenes);
        return "listado_almacenes";
    }*/


}

package com.iescm.dam2.ad.proyecto.ogp_hosb.amazin.model.producto;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;

@Controller
@RequestMapping("/api/productos")
public class ProductoController{

    @Autowired
    private ProductoService service;

    @GetMapping
    public List<Producto> listaProductos(){
        return service.listarProductos();
    }

    

       
    @GetMapping("/{id}")
    public ResponseEntity<Producto> productoPorId(@PathVariable Long id){
        Optional<Producto> producto = service.obtenerPorId(id);
        return producto.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Producto crearProducto(@Valid @RequestBody Producto producto){
        return service.crearProducto(producto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Producto> actualizarProducto(
        @PathVariable Long id, @RequestBody Producto producto){
            Producto prodUpdate = service.actualizarProducto(id, producto);
            return (prodUpdate != null) ? ResponseEntity.ok(prodUpdate)
                : ResponseEntity.notFound().build();
    }

    @GetMapping("/categorias/{categoria}")
    public List<Producto> listarPorCategoria(@PathVariable String categoria) {
        return service.listarPorCategoria(categoria);
    }

    @GetMapping("/precios/{precio}")
    public List<Producto> listarPorPrecioMayorQue(@PathVariable Double precio){
        return service.listarPorPrecioMayorQue(precio);
    }

    @PostMapping("/{id}/delete")
    public String eliminarProducto(@PathVariable Long id, Model model){
        service.eliminarProducto(id);
        List<Producto> productos = service.listarProductos();
        model.addAttribute("productos", productos);
        return "listado_productos";
    }

   

}
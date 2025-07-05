package com.dam2.project.amazin.model.pedido;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.dam2.project.amazin.model.almacen.Almacen;
import com.dam2.project.amazin.model.almacen.AlmacenService;
import com.dam2.project.amazin.model.destino.Destino;
import com.dam2.project.amazin.model.destino.DestinoService;
import com.dam2.project.amazin.model.producto.Producto;
import com.dam2.project.amazin.model.producto.ProductoService;

@Controller
public class HacerPedidoController {
 
    @Autowired
    private PedidoService pedidoService;

    @Autowired
    private AlmacenService almacenService;

    @Autowired
    private ProductoService productoService;

    @Autowired
    private DestinoService destinoService;


    @GetMapping("/hacerpedido")
    public String pedidoForm(Model model){

        List<Destino> destinos= destinoService.listarDestinos();
        List<Producto> productos= productoService.listarProductos();
        List<Almacen> almacenes = almacenService.listarAlmacenes();

        model.addAttribute("pedido", new Pedido());
        model.addAttribute("almacenes", almacenes);
        model.addAttribute("productos", productos);
        model.addAttribute("destinos", destinos);
        return "fragments/modal_hacerpedido";
    }


}

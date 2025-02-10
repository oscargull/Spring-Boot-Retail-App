package com.iescm.dam2.ad.proyecto.ogp_hosb.amazin.model.pedido;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping
public class PedidoControllerList {

    @Autowired
    private PedidoService service;
    
    @GetMapping("/pedidos")
    public String listarProductos(Model model){
        List<Pedido> pedidos = service.listarPedidoss();
        model.addAttribute("pedidos", pedidos);
        return "listado_pedidos"; // Devuelve la plantilla "listado.html"
    }

    @GetMapping("/pedidos/estado")
    public String listarProductosPorEstado(@RequestParam("estado") String estado, Model model){
        List<Pedido> pedidos = service.listarPorEstado(estado);
        model.addAttribute("pedidos", pedidos);
        return "listado_pedidos"; // Devuelve la plantilla "listado.html"
    }


}

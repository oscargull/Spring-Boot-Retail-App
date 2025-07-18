package com.dam2.project.amazin.controller;

import java.util.List;

import com.dam2.project.amazin.model.Pedido;
import com.dam2.project.amazin.service.PedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
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
    public String listarProductosPorEstado(@RequestParam("estado") Pedido.Estado estado, Model model){
        List<Pedido> pedidos = service.listarPorEstado(estado);
        model.addAttribute("pedidos", pedidos);
        return "fragments/modal_tablapedidos";
    }


}

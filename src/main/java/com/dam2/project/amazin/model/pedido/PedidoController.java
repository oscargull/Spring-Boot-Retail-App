package com.dam2.project.amazin.model.pedido;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/pedidos")
public class PedidoController {

    @Autowired
    private PedidoRepository pedidoRepository;

    @Autowired
    private PedidoService pedidoService;


    // Obtener pedido por ID
    @GetMapping("/search")
    public String searchPedido(
            @RequestParam(required = false) Long pedidoId,
            Model model) {
        Pedido pedido = pedidoService.searchPedidosById(pedidoId);
        model.addAttribute("pedido", pedido);
        model.addAttribute("pedidoId", pedidoId);
        return "search_pedido";
    }

    // Edit Pedido
    @GetMapping("/pedido/edit/{id}")
    public String editPedido(@PathVariable Long id, Model model) {
        Pedido pedido = pedidoService.findPedidoById(id);
        if (pedido != null) {
            model.addAttribute("pedido", pedido);
            return "edit_pedido";
        } else {
            model.addAttribute("message", "Pedido not found.");
            return "search_pedido";
        }
    }

    // Update Pedido
    @PostMapping("/pedido/edit/{id}")
    public String updatePedido(@PathVariable Long id, @ModelAttribute Pedido updatedPedido, Model model) {
        Pedido pedido = pedidoService.findPedidoById(id);
        if (pedido != null) {
            pedido.setEstado(updatedPedido.getEstado());
            pedido.setFecha_de_pedido(updatedPedido.getFecha_de_pedido());
            pedido.setFecha_de_llegada(updatedPedido.getFecha_de_llegada());
            pedido.setDescripcion(updatedPedido.getDescripcion());
            pedido.setAlmacen_id(updatedPedido.getAlmacen_id());
            pedido.setProducto_id(updatedPedido.getProducto_id());
            pedido.setDestino_id(updatedPedido.getDestino_id());
            pedidoService.save(pedido);  // Save the updated Pedido to the database
            model.addAttribute("message", "Pedido updated successfully!");
        } else {
            model.addAttribute("message", "Pedido not found.");
        }
        return "search_pedido";
    }

    // Delete Pedido
    @GetMapping("/pedido/delete/{id}")
    public String deletePedido(@PathVariable Long id, Model model) {
        Pedido pedido = pedidoService.findPedidoById(id);
        if (pedido != null) {
            pedidoService.delete(id);  // Delete the Pedido by its ID
            model.addAttribute("message", "Pedido deleted successfully.");
        } else {
            model.addAttribute("message", "Pedido not found.");
        }
        return "search_pedido";
    }


    @RequestMapping(value="/hacerpedido", method=RequestMethod.POST)
    public @ResponseBody Pedido hacerPedido(@ModelAttribute("pedido") Pedido pedido, Model model)
    {
        pedidoService.crearPedido(pedido);
        model.addAttribute("pedido", pedido);
        return pedido;
    }

    @PostMapping("/{id}/delete")
    public String eliminarPedido(@PathVariable Long id, Model model){
        pedidoService.eliminarPedido(id);
        List<Pedido> pedidos = pedidoService.listarPedidoss();
        model.addAttribute("pedidos", pedidos);
        return "listado_pedidos";
    }

}

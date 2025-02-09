package com.iescm.dam2.ad.proyecto.ogp_hosb.amazin.model.pedido;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
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
    public Pedido searchPedidoById(@RequestParam Long pedido_id) {
        Optional<Pedido> pedido = pedidoRepository.findById(pedido_id);
        return pedido.orElse(null);  // Return the Pedido if found, or null if not found
    }

    // Endpoint to edit a pedido
    @PutMapping("/{pedido_id}")
    public Pedido updatePedido(@PathVariable Long pedido_id, @RequestBody Pedido pedidoDetails) {
        Optional<Pedido> optionalPedido = pedidoService.obtenerPorId(pedido_id);
        if (optionalPedido.isPresent()) {
            Pedido pedido = optionalPedido.get();
            pedido.setEstado(pedidoDetails.getEstado());
            pedido.setDescripcion(pedidoDetails.getDescripcion());
            pedido.setDestino_id(pedidoDetails.getDestino_id());
            pedido.setFecha_de_llegada(pedidoDetails.getFecha_de_llegada());
            pedido.setFecha_de_pedido(pedidoDetails.getFecha_de_pedido());
            pedido.setAlmacen_id(pedidoDetails.getAlmacen_id());
            pedido.setProducto_id(pedidoDetails.getProducto_id());
            return pedidoRepository.save(pedido);
        }
        return null;
    }

    // Endpoint to delete a pedido
    @DeleteMapping("/{pedido_id}")
    public void deletePedido(@PathVariable Long pedido_id) {
        pedidoService.eliminarPedido(pedido_id);
    }


    @RequestMapping(value="/hacerpedido", method=RequestMethod.POST)
    public @ResponseBody Pedido hacerPedido(@ModelAttribute("pedido") Pedido pedido, Model model)
    {
        pedidoService.crearPedido(pedido);
        model.addAttribute("pedido", pedido);
        return pedido;
    }

}

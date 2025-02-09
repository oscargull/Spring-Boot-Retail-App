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
    @GetMapping("/{id}")
    public ResponseEntity<Pedido> getPedidoById(@PathVariable Long id) {
        Optional<Pedido> pedido = pedidoRepository.findById(id);
        return pedido.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }

    // Eliminar pedido por ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePedido(@PathVariable Long id) {
        if (pedidoRepository.existsById(id)) {
            pedidoRepository.deleteById(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    // Actualizar pedido por ID
    @PutMapping("/{id}")
    @PostMapping("/buscarpedido")
    public ResponseEntity<Pedido> updatePedido(@PathVariable Long id, @RequestBody Pedido updatedPedido) {
        return pedidoRepository.findById(id)
                .map(pedido -> {
                    pedido.setEstado(updatedPedido.getEstado());
                    pedido.setFecha_de_pedido(updatedPedido.getFecha_de_pedido());
                    pedido.setFecha_de_llegada(updatedPedido.getFecha_de_llegada());
                    pedido.setDescripcion(updatedPedido.getDescripcion());
                    pedido.setAlmacen_id(updatedPedido.getAlmacen_id());
                    pedido.setProducto_id(updatedPedido.getProducto_id());
                    pedido.setDestino_id(updatedPedido.getDestino_id());
                    pedidoRepository.save(pedido);
                    return ResponseEntity.ok(pedido);
                })
                .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }


    @RequestMapping(value="/hacerpedido", method=RequestMethod.POST)
    public @ResponseBody Pedido hacerPedido(@ModelAttribute("pedido") Pedido pedido, Model model)
    {
        pedidoService.crearPedido(pedido);
        model.addAttribute("pedido", pedido);
        return pedido;
    }

}

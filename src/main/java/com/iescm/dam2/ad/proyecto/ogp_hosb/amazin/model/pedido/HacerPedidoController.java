package com.iescm.dam2.ad.proyecto.ogp_hosb.amazin.model.pedido;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.iescm.dam2.ad.proyecto.ogp_hosb.amazin.model.almacen.Almacen;
import com.iescm.dam2.ad.proyecto.ogp_hosb.amazin.model.almacen.AlmacenService;
import com.iescm.dam2.ad.proyecto.ogp_hosb.amazin.model.destino.Destino;
import com.iescm.dam2.ad.proyecto.ogp_hosb.amazin.model.destino.DestinoService;
import com.iescm.dam2.ad.proyecto.ogp_hosb.amazin.model.producto.Producto;
import com.iescm.dam2.ad.proyecto.ogp_hosb.amazin.model.producto.ProductoService;

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
        return "fragments/modal_hacerpedido :: modal";
    }

    @PostMapping("/hacerpedido")
    public Pedido hacerPedido(@ModelAttribute Pedido pedido, Model model) {
       return pedidoService.crearPedido(pedido);
    }

}

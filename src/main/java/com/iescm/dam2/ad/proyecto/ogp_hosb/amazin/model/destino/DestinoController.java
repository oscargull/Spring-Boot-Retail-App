package com.iescm.dam2.ad.proyecto.ogp_hosb.amazin.model.destino;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/api/destinos")
public class DestinoController {
    @Autowired
    DestinoService destinoService;

    @GetMapping
    @ResponseBody
    public List<Destino> listarDestinos(){
        return destinoService.listarDestinos();
    }
}

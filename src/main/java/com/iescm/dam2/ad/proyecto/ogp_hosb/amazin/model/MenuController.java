package com.iescm.dam2.ad.proyecto.ogp_hosb.amazin.model;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MenuController {
    @GetMapping("/menu")
    public String menuForm(Model model){

        //model.addAttribute("menu", menu )
        return "menu";
    }
}

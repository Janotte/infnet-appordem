package br.edu.infnet.appordem.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class ComponenteController {

    @GetMapping("/componentes")
    public String getComponentes() {
        return "/componente/componente-list";
    }

    @GetMapping("/componente-view/{codigo}")
    public String getComponenteByCodigo() {
        return "/componente/componente-view";
    }

    @GetMapping("/componente-add")
    public String addComponente() {
        return "/componente/componente-add";
    }

    @GetMapping("/componente-update/{codigo}")
    public String updateComponente(@PathVariable(value = "codigo") Long codigo) {
        return "/componente/componente-update";
    }

    @DeleteMapping("/componente/{codigo}")
    public String deleteComponente(@PathVariable(value = "codigo") Long codigo) {
        return "/componente/componente-delete";
    }
}

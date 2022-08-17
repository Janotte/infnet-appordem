package br.edu.infnet.appordem.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class ClienteController {

    @GetMapping("/clientes")
    public String getClientes() {
        return "/cliente/cliente-list";
    }

    @GetMapping("/cliente-view/{codigo}")
    public String getClienteByCodigo() {
        return "/cliente/cliente-view";
    }

    @GetMapping("/cliente-add")
    public String addCliente() {
        return "/cliente/cliente-add";
    }

    @GetMapping("/cliente-update/{codigo}")
    public String updateCliente(@PathVariable(value = "codigo") Long codigo) {
        return "/cliente/cliente-update";
    }

    @DeleteMapping("cliente/{codigo}")
    public String deleteCliente(@PathVariable(value = "codigo") Long codigo) {
        return "/cliente/cliente-delete";
    }
}

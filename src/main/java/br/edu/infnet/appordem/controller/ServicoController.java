package br.edu.infnet.appordem.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/servicos")
public class ServicoController {

    @GetMapping
    public String  clientePage() {
        return "/servico/lista";
    }
}

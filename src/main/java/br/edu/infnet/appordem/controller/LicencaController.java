package br.edu.infnet.appordem.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/licencas")
public class LicencaController {

    @GetMapping
    public String  clientePage() {
        return "/licenca/lista";
    }
}

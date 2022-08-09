package br.edu.infnet.appordem.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/ordens")
public class OrdemController {

    @GetMapping
    public String  clientePage() {
        return "/ordem/lista";
    }
}

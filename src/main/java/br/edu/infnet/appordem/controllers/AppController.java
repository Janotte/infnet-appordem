package br.edu.infnet.appordem.controllers;

import br.edu.infnet.appordem.model.domain.Usuario;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class AppController {

    @GetMapping("/")
    public String  homePage() {
        return "home/home";
    }

    @GetMapping("/login")
    public String  loginPage() {
        return "login/loginPage";
    }

    @PostMapping("/login")
    public String login(Model model, @RequestParam String email, @RequestParam  String senha) {
        Usuario usuario = UsuarioController.validar(email, senha);
        if(usuario != null) {
            model.addAttribute("user", usuario);
            return "home/home";
        }

        return "redirect:/login";
    }

    @GetMapping("/logout")
    public String  loginPage(Model model) {
        model.addAttribute("user", "");
        return "redirect:/";
    }
}

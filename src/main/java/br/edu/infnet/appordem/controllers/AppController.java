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

        if(email.equalsIgnoreCase(senha)) {
            String nome = "Admin";
            model.addAttribute("user", nome);

            return "home/home";
        }
        return "redirect:/login";
    }

    @GetMapping("/logout")
    public String  loginPage(Model model) {
        model.addAttribute("user", "");
        return "redirect:/";
    }

    @GetMapping("/signup")
    public String  signupPage(Model model) {
        model.addAttribute("usuario", new Usuario());
        model.addAttribute("pageTitle", "Cadastrar");
        model.addAttribute("formAction", "/usuario/registrar");

        return "login/signupPage";
    }

}

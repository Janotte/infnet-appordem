package br.edu.infnet.appordem.controllers;

import br.edu.infnet.appordem.model.domain.Usuario;
import br.edu.infnet.appordem.model.service.AppService;
import br.edu.infnet.appordem.model.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import javax.servlet.http.HttpSession;

@SessionAttributes("auth")
@Controller
public class AppController {

    @Autowired
    private AppService appService;

    @Autowired
    private UsuarioService usuarioService;

    @GetMapping("/")
    public String homePage(Model model) {
        model.addAttribute("projeto", appService.obterProjeto());
        return "home/home";
    }

    @GetMapping("/login")
    public String loginPage() {
        return "/login/login";
    }

    @PostMapping("/login")
    public String login(Model model, @RequestParam String email, @RequestParam String senha) {
        model.addAttribute("pageTitle", "Login");
        Usuario usuario = usuarioService.validar(email, senha);
        if (usuario != null) {
            model.addAttribute("auth", usuario);
            return "redirect:/";
        }

        return "redirect:/login";
    }

    @GetMapping("/logout")
    public String loginPage(HttpSession session, SessionStatus status) {
        status.setComplete();
        session.removeAttribute("auth");
        return "redirect:/";
    }
}

package br.edu.infnet.appordem.controllers;

import br.edu.infnet.appordem.model.domain.Usuario;
import br.edu.infnet.appordem.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @GetMapping("/usuarios")
    public String listPage(Model model) {
        model.addAttribute("usuarioList", usuarioService.obterLista());
        return "/usuario/listar_page";
    }

    @GetMapping("/usuario/adicionar")
    public String createPage(Model model) {
        model.addAttribute("usuario", new Usuario());
        model.addAttribute("pageTitle", "Adicionar Usuário");
        model.addAttribute("formAction", "/usuario/adicionar");
        return "/usuario/adicionar_page";
    }

    @PostMapping("/usuario/adicionar")
    public String create(@ModelAttribute("usuario") Usuario usuario) {
        usuarioService.incluir(usuario);
        return "redirect:/usuarios";
    }

    @GetMapping("/signup")
    public String signupPage(Model model) {
        model.addAttribute("usuario", new Usuario());
        model.addAttribute("pageTitle", "Cadastrar");
        model.addAttribute("formAction", "/usuario/registrar");

        return "login/signupPage";
    }

    @PostMapping("/usuario/registrar")
    public String signup(@ModelAttribute("usuario") Usuario usuario) {
        usuarioService.incluir(usuario);
        return "redirect:/";
    }

    @GetMapping("/usuario/{email}/atualizar")
    public String updatePage(@PathVariable(value = "email") String email, HttpServletRequest req) {
        req.setAttribute("usuario", usuarioService.obterPorEmail(email));
        req.setAttribute("pageTitle", "Atualizar Usuário");
        req.setAttribute("formAction", "/usuario/" + email + "/atualizar");
        return "/usuario/atualizar_page";
    }

    @PostMapping("/usuario/{email}/atualizar")
    public String update(@PathVariable(value = "email") String email, @ModelAttribute("usuario") Usuario usuario) {
        usuarioService.atualizar(email, usuario);
        return "redirect:/usuarios";
    }

    @GetMapping("/usuario/{email}/excluir")
    public String deletePage(@PathVariable(value = "email") String email) {
        usuarioService.excluir(email);
        System.out.println("Excluído item " + email);
        return "redirect:/usuarios";
    }
}


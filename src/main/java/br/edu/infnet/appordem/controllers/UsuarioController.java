package br.edu.infnet.appordem.controllers;

import br.edu.infnet.appordem.model.domain.Mensagem;
import br.edu.infnet.appordem.model.domain.Usuario;
import br.edu.infnet.appordem.model.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    private Mensagem mensagem;

    @GetMapping("/usuarios")
    public String listPage(Model model) {
        model.addAttribute("pageTitle", "Usuários");
        model.addAttribute("usuarioList", usuarioService.obterLista());
        model.addAttribute("mensagem", mensagem);
        return "/usuario/listar_usuarios";
    }

    @GetMapping("/usuario/adicionar")
    public String createPage(Model model) {
        model.addAttribute("usuario", new Usuario());
        model.addAttribute("pageTitle", "Adicionar Usuário");
        model.addAttribute("formAction", "/usuario/adicionar");
        return "/usuario/adicionar_usuario";
    }

    @PostMapping("/usuario/adicionar")
    public String create(@ModelAttribute("usuario") Usuario usuario) {
        mensagem = new Mensagem();
        try {
            usuarioService.incluir(usuario);
            mensagem.setTexto("Usuário criado com sucesso!");
            mensagem.setTipo("alert-success");
        } catch (Exception e) {
            mensagem.setTexto("Não é possível criar o usuário!");
            mensagem.setTipo("alert-danger");
        }
        return "redirect:/usuarios";
    }

    @GetMapping("/signup")
    public String signupPage(Model model) {
        model.addAttribute("usuario", new Usuario());
        model.addAttribute("pageTitle", "Registrar Usuário");
        model.addAttribute("formAction", "/usuario/registrar");

        return "login/signup";
    }

    @PostMapping("/usuario/registrar")
    public String signup(@ModelAttribute("usuario") Usuario usuario) {
        mensagem = new Mensagem();
        try {
            usuarioService.incluir(usuario);
            mensagem.setTexto("Usuário registrado com sucesso!");
            mensagem.setTipo("alert-success");
        } catch (Exception e) {
            mensagem.setTexto("Não é possível registrar o usuário!");
            mensagem.setTipo("alert-danger");
        }
        return "redirect:/";
    }

    @GetMapping("/usuario/{id}/atualizar")
    public String updatePage(@PathVariable(value = "id") Long id, HttpServletRequest req) {
        req.setAttribute("usuario", usuarioService.obterPorId(id).get());
        req.setAttribute("pageTitle", "Atualizar Usuário");
        req.setAttribute("formAction", "/usuario/" + id + "/atualizar");
        return "/usuario/atualizar_usuario";
    }

    @PostMapping("/usuario/{id}/atualizar")
    public String update(@PathVariable(value = "id") Long id, @ModelAttribute("usuario") Usuario usuario) {
        mensagem = new Mensagem();
        try {
            usuarioService.atualizar(id, usuario);
            mensagem.setTexto("Usuário atualizado com sucesso!");
            mensagem.setTipo("alert-success");
        } catch (Exception e) {
            mensagem.setTexto("Não é possível atualizar o usuário!");
            mensagem.setTipo("alert-danger");
        }
        return "redirect:/usuarios";
    }

    @GetMapping("/usuario/{id}/excluir")
    public String deletePage(@PathVariable(value = "id") Long id) {
        mensagem = new Mensagem();
        try {
            usuarioService.excluir(id);
            mensagem.setTexto("Usuário excluído com sucesso!");
            mensagem.setTipo("alert-success");
        } catch (Exception e) {
            mensagem.setTexto("Não é possível excluir o usuário!");
            mensagem.setTipo("alert-danger");
        }
        return "redirect:/usuarios";
    }
}

package br.edu.infnet.appordem.controllers;

import br.edu.infnet.appordem.model.domain.Usuario;
import br.edu.infnet.appordem.services.AppImpressao;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Controller
public class UsuarioController {

    private static Map<String, Usuario> usuarioMap = new HashMap<>();
    private static Long id = 1L;

    public static void incluir(Usuario usuario) {
        usuario.setId(id++);
        usuarioMap.put(usuario.getEmail(), usuario);
        AppImpressao.relatorio("Incluído o usuário: " + usuario.getNome(), usuario);
    }

    public static Collection<Usuario> obterLista() {
        return usuarioMap.values();
    }

    public static void excluir(String email) {
        usuarioMap.remove(email);
    }

    public static Usuario obterPorEmail(String email) {
        return usuarioMap.get(email);
    }

    public static void atualizar(String email, Usuario usuario) {
        usuarioMap.put(email, usuario);
        AppImpressao.relatorio("Atualizado o usuário: " + usuario.getNome(), usuario);
    }

    public static Usuario validar(String email, String senha) {
        Usuario usuario = obterPorEmail(email);
        if(usuario != null && usuario.getSenha().equals(senha)) {;
            return usuario;
        }
        return null;
    }

    @GetMapping("/usuarios")
    public String listPage(Model model) {
        model.addAttribute("usuarioList", obterLista());
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
        incluir(usuario);
        return "redirect:/usuarios";
    }


    @GetMapping("/signup")
    public String  signupPage(Model model) {
        model.addAttribute("usuario", new Usuario());
        model.addAttribute("pageTitle", "Cadastrar");
        model.addAttribute("formAction", "/usuario/registrar");

        return "login/signupPage";
    }

    @PostMapping("/usuario/registrar")
    public String signup(@ModelAttribute("usuario") Usuario usuario) {
        incluir(usuario);
        return "redirect:/";
    }

    @GetMapping("/usuario/{email}/atualizar")
    public String updatePage(@PathVariable(value = "email") String email, HttpServletRequest req) {
        req.setAttribute("usuario", obterPorEmail(email));
        req.setAttribute("pageTitle", "Atualizar Usuário");
        req.setAttribute("formAction", "/usuario/" + email + "/atualizar");
        return "/usuario/atualizar_page";
    }

    @PostMapping("/usuario/{email}/atualizar")
    public String update(@PathVariable(value = "email") String email, @ModelAttribute("usuario") Usuario usuario) {
        atualizar(email, usuario);
        return "redirect:/usuarios";
    }

    @GetMapping("/usuario/{email}/excluir")
    public String deletePage(@PathVariable(value = "email") String  email) {
        excluir(email);
        System.out.println("Excluído item " + email);
        return "redirect:/usuarios";
    }
}


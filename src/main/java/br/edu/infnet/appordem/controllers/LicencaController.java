package br.edu.infnet.appordem.controllers;

import br.edu.infnet.appordem.model.domain.Licenca;
import br.edu.infnet.appordem.model.domain.Mensagem;
import br.edu.infnet.appordem.model.domain.Usuario;
import br.edu.infnet.appordem.model.service.LicencaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@Controller
public class LicencaController {

    @Autowired
    private LicencaService licencaService;

    private Mensagem mensagem;

    @GetMapping("/licencas")
    public String listPage(Model model, @SessionAttribute("auth") Usuario usuario) {
        model.addAttribute("pageTitle", "Licencas");
        model.addAttribute("licencaList", licencaService.obterLista(usuario));
        model.addAttribute("mensagem", mensagem);
        return "/licenca/listar_licencas";
    }

    @GetMapping("/licenca/adicionar")
    public String createPage(Model model) {
        model.addAttribute("licenca", new Licenca());
        model.addAttribute("pageTitle", "Adicionar Licenca");
        model.addAttribute("formAction", "/licenca/adicionar");
        return "/licenca/adicionar_licenca";
    }

    @PostMapping("/licenca/adicionar")
    public String create(@ModelAttribute("licenca") Licenca licenca, @SessionAttribute("auth") Usuario usuario) {
        mensagem = new Mensagem();
        try {
            licenca.setUsuario(usuario);
            licenca.setPrecoVenda(licenca.calcularPrecoVenda());
            licencaService.incluir(licenca, usuario);
            mensagem.setTexto("Licenca criado com sucesso!");
            mensagem.setTipo("alert-success");
        } catch (Exception e) {
            mensagem.setTexto("Não é possível criar o licenca!");
            mensagem.setTipo("alert-danger");
        }
        return "redirect:/licencas";
    }

    @GetMapping("/licenca/{id}/atualizar")
    public String updatePage(@PathVariable(value = "id") Long id, HttpServletRequest req) {
        req.setAttribute("licenca", licencaService.obterPorId(id).get());
        req.setAttribute("pageTitle", "Atualizar Licenca");
        req.setAttribute("formAction", "/licenca/" + id + "/atualizar");
        return "/licenca/atualizar_licenca";
    }

    @PostMapping("/licenca/{id}/atualizar")
    public String update(@PathVariable(value = "id") Long id, @ModelAttribute("licenca") Licenca licenca, @SessionAttribute("auth") Usuario usuario) {
        mensagem = new Mensagem();
        try {
            licenca.setUsuario(usuario);
            licenca.setPrecoVenda(licenca.calcularPrecoVenda());
            licencaService.atualizar(id, licenca);
            mensagem.setTexto("Licenca atualizado com sucesso!");
            mensagem.setTipo("alert-success");
        } catch (Exception e) {
            mensagem.setTexto("Não é possível atualizar o licenca!");
            mensagem.setTipo("alert-danger");
        }
        return "redirect:/licencas";
    }

    @GetMapping("/licenca/{id}/excluir")
    public String deletePage(@PathVariable(value = "id") Long id) {
        mensagem = new Mensagem();
        try {
            licencaService.excluir(id);
            mensagem.setTexto("Licenca excluído com sucesso!");
            mensagem.setTipo("alert-success");
        } catch (Exception e) {
            mensagem.setTexto("Não é possível excluir o licenca!");
            mensagem.setTipo("alert-danger");
        }
        return "redirect:/licencas";
    }
}
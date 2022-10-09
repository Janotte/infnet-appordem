package br.edu.infnet.appordem.controllers;

import br.edu.infnet.appordem.model.domain.Mensagem;
import br.edu.infnet.appordem.model.domain.Servico;
import br.edu.infnet.appordem.model.domain.Usuario;
import br.edu.infnet.appordem.model.service.ServicoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@Controller
public class ServicoController {

    @Autowired
    private ServicoService servicoService;

    private Mensagem mensagem;

    @GetMapping("/servicos")
    public String listPage(Model model, @SessionAttribute("auth") Usuario usuario) {
        model.addAttribute("servicoList", servicoService.obterLista(usuario));
        model.addAttribute("mensagem", mensagem);
        return "/servico/listar_servicos";
    }

    @GetMapping("/servico/adicionar")
    public String createPage(Model model) {
        model.addAttribute("servico", new Servico());
        model.addAttribute("pageTitle", "Adicionar Serviço");
        model.addAttribute("formAction", "/servico/adicionar");
        return "/servico/adicionar_servico";
    }

    @PostMapping("/servico/adicionar")
    public String create(@ModelAttribute("servico") Servico servico, @SessionAttribute("auth") Usuario usuario) {
        mensagem = new Mensagem();
        try {
            servico.setUsuario(usuario);
            servico.setPrecoVenda(servico.calcularPrecoVenda());
            servicoService.incluir(servico, usuario);
            mensagem.setTexto("Serviço criado com sucesso!");
            mensagem.setTipo("alert-success");
        } catch (Exception e) {
            mensagem.setTexto("Não é possível criar o serviço!");
            mensagem.setTipo("alert-danger");
        }
        return "redirect:/servicos";
    }

    @GetMapping("/servico/{id}/atualizar")
    public String updatePage(@PathVariable(value = "id") Long id, HttpServletRequest req) {
        req.setAttribute("servico", servicoService.obterPorId(id).get());
        req.setAttribute("pageTitle", "Atualizar Serviço");
        req.setAttribute("formAction", "/servico/" + id + "/atualizar");
        return "/servico/atualizar_servico";
    }

    @PostMapping("/servico/{id}/atualizar")
    public String update(@PathVariable(value = "id") Long id, @ModelAttribute("servico") Servico servico, @SessionAttribute("auth") Usuario usuario) {
        mensagem = new Mensagem();
        try {
            servico.setUsuario(usuario);
            servico.setPrecoVenda(servico.calcularPrecoVenda());
            servicoService.atualizar(id, servico);
            mensagem.setTexto("Serviço atualizado com sucesso!");
            mensagem.setTipo("alert-success");
        } catch (Exception e) {
            mensagem.setTexto("Não é possível atualizar o serviço!");
            mensagem.setTipo("alert-danger");
        }
        return "redirect:/servicos";
    }

    @GetMapping("/servico/{id}/excluir")
    public String deletePage(@PathVariable(value = "id") Long id) {
        mensagem = new Mensagem();
        try {
            servicoService.excluir(id);
            mensagem.setTexto("Serviço excluído com sucesso!");
            mensagem.setTipo("alert-success");
        } catch (Exception e) {
            mensagem.setTexto("Não é possível excluir o serviço!");
            mensagem.setTipo("alert-danger");
        }
        return "redirect:/servicos";
    }
}


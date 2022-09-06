package br.edu.infnet.appordem.controllers;

import br.edu.infnet.appordem.model.domain.Servico;
import br.edu.infnet.appordem.services.ServicoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
public class ServicoController {

    @Autowired
    private ServicoService servicoService;

    @GetMapping("/servicos")
    public String listPage(Model model) {
        model.addAttribute("servicoList", servicoService.obterLista());
        return "/servico/listar_page";
    }

    @GetMapping("/servico/adicionar")
    public String createPage(Model model) {
        model.addAttribute("servico", new Servico());
        model.addAttribute("pageTitle", "Adicionar Serviço");
        model.addAttribute("formAction", "/servico/adicionar");
        return "/servico/adicionar_page";
    }

    @PostMapping("/servico/adicionar")
    public String create(@ModelAttribute("servico") Servico servico) {
        servico.setPrecoVenda(servico.calcularPrecoVenda());
        servicoService.incluir(servico);
        return "redirect:/servicos";
    }

    @GetMapping("/servico/{id}/atualizar")
    public String updatePage(@PathVariable(value = "id") Long id, HttpServletRequest req) {
        req.setAttribute("servico", servicoService.obterPorId(id));
        req.setAttribute("pageTitle", "Atualizar Serviço");
        req.setAttribute("formAction", "/servico/" + id + "/atualizar");
        return "/servico/atualizar_page";
    }

    @PostMapping("/servico/{id}/atualizar")
    public String update(@PathVariable(value = "id") Long id, @ModelAttribute("servico") Servico servico) {
        servicoService.atualizar(id, servico);
        return "redirect:/servicos";
    }

    @GetMapping("/servico/{id}/excluir")
    public String deletePage(@PathVariable(value = "id") Long id) {
        servicoService.excluir(id);
        System.out.println("Excluído item " + id);
        return "redirect:/servicos";
    }
}


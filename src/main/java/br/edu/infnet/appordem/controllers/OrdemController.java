package br.edu.infnet.appordem.controllers;

import br.edu.infnet.appordem.model.domain.Ordem;
import br.edu.infnet.appordem.model.domain.Situacao;
import br.edu.infnet.appordem.model.services.ClienteService;
import br.edu.infnet.appordem.model.services.OrdemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;

@Controller
public class OrdemController {

    @Autowired
    private OrdemService ordemService;

    @Autowired
    private ClienteService clienteService;

    @GetMapping("/ordens")
    public String listPage(Model model) {
        model.addAttribute("ordemList", ordemService.obterLista());
        return "/ordem/listar_page";
    }

    @GetMapping("/ordem/adicionar")
    public String createPage(Model model) {
        model.addAttribute("ordem", new Ordem());
        model.addAttribute("clienteList", clienteService.obterLista());
        model.addAttribute("pageTitle", "Adicionar Ordem");
        model.addAttribute("formAction", "/ordem/adicionar");
        return "/ordem/adicionar_page";
    }

    @PostMapping("/ordem/adicionar")
    public String create(Ordem ordem, @RequestParam(value = "clienteId") Long clienteId, Model model) {
        ordem.setSituacao(Situacao.ABERTA);
        ordem.setCliente(clienteService.obterPorId(clienteId));
        ordem.setDataAbertura(new Date(System.currentTimeMillis()));
        ordemService.incluir(ordem);
        return "redirect:/ordens";
    }

    @GetMapping("/ordem/{id}/atualizar")
    public String updatePage(@PathVariable(value = "id") Long id, HttpServletRequest req) {
        req.setAttribute("ordem", ordemService.obterPorId(id));
        req.setAttribute("pageTitle", "Atualizar Ordem");
        req.setAttribute("formAction", "/ordem/" + id + "/atualizar");
        return "/ordem/atualizar_page";
    }

    @PostMapping("/ordem/{id}/atualizar")
    public String update(@PathVariable(value = "id") Long id, @ModelAttribute("ordem") Ordem ordem) {
        ordemService.atualizar(id, ordem);
        return "redirect:/ordens";
    }

    @GetMapping("/ordem/{id}/excluir")
    public String deletePage(@PathVariable(value = "id") Long id) {
        ordemService.excluir(id);
        System.out.println("Excluído item " + id);
        return "redirect:/ordens";
    }
}

package br.edu.infnet.appordem.controllers;

import br.edu.infnet.appordem.model.domain.Componente;
import br.edu.infnet.appordem.model.services.ComponenteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
public class ComponenteController {

    @Autowired
    private ComponenteService componenteService;


    @GetMapping("/componentes")
    public String listPage(Model model) {
        model.addAttribute("componenteList", componenteService.obterLista());
        return "/componente/listar_page";
    }

    @GetMapping("/componente/adicionar")
    public String createPage(Model model) {
        model.addAttribute("componente", new Componente());
        model.addAttribute("pageTitle", "Adicionar Componente");
        model.addAttribute("formAction", "/componente/adicionar");
        return "/componente/adicionar_page";
    }

    @PostMapping("/componente/adicionar")
    public String create(@ModelAttribute("componente") Componente componente) {
        componente.setCustoCompra(componente.calcularValorCusto());
        componente.setPrecoVenda(componente.calcularPrecoVenda());
        componenteService.incluir(componente);
        return "redirect:/componentes";
    }

    @GetMapping("/componente/{id}/atualizar")
    public String updatePage(@PathVariable(value = "id") Long id, HttpServletRequest req) {
        req.setAttribute("componente", componenteService.obterPorId(id));
        req.setAttribute("pageTitle", "Atualizar Componente");
        req.setAttribute("formAction", "/componente/" + id + "/atualizar");
        return "/componente/atualizar_page";
    }

    @PostMapping("/componente/{id}/atualizar")
    public String update(@PathVariable(value = "id") Long id, @ModelAttribute("componente") Componente componente) {
        componenteService.atualizar(id, componente);
        return "redirect:/componentes";
    }

    @GetMapping("/componente/{id}/excluir")
    public String deletePage(@PathVariable(value = "id") Long id) {
        componenteService.excluir(id);
        System.out.println("Excluído item " + id);
        return "redirect:/componentes";
    }
}

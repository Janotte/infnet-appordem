package br.edu.infnet.appordem.controllers;

import br.edu.infnet.appordem.model.domain.Licenca;
import br.edu.infnet.appordem.services.LicencaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
public class LicencaController {

    @Autowired
    private LicencaService licencaService;

    @GetMapping("/licencas")
    public String listPage(Model model) {
        model.addAttribute("licencaList", licencaService.obterLista());
        return "/licenca/listar_page";
    }

    @GetMapping("/licenca/adicionar")
    public String createPage(Model model) {
        model.addAttribute("licenca", new Licenca());
        model.addAttribute("pageTitle", "Adicionar Licença");
        model.addAttribute("formAction", "/licenca/adicionar");
        return "/licenca/adicionar_page";
    }

    @PostMapping("/licenca/adicionar")
    public String create(@ModelAttribute("licenca") Licenca licenca) {
        licenca.setPrecoVenda(licenca.calcularPrecoVenda());
        licencaService.incluir(licenca);
        return "redirect:/licencas";
    }

    @GetMapping("/licenca/{id}/atualizar")
    public String updatePage(@PathVariable(value = "id") Long id, HttpServletRequest req) {
        req.setAttribute("licenca", licencaService.obterPorId(id));
        req.setAttribute("pageTitle", "Atualizar Licença");
        req.setAttribute("formAction", "/licenca/" + id + "/atualizar");
        return "/licenca/atualizar_page";
    }

    @PostMapping("/licenca/{id}/atualizar")
    public String update(@PathVariable(value = "id") Long id, @ModelAttribute("licenca") Licenca licenca) {
        licencaService.atualizar(id, licenca);
        return "redirect:/licencas";
    }

    @GetMapping("/licenca/{id}/excluir")
    public String deletePage(@PathVariable(value = "id") Long id) {
        licencaService.excluir(id);
        System.out.println("Excluído item " + id);
        return "redirect:/licencas";
    }
}

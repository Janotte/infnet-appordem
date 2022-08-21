package br.edu.infnet.appordem.controller;

import br.edu.infnet.appordem.model.domain.Ordem;
import br.edu.infnet.appordem.service.AppImpressao;
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
public class OrdemController {

    private static Map<Long, Ordem> ordemMap = new HashMap<>();
    private static Long id = 1L;

    public static void incluir(Ordem ordem) {
        ordem.setId(id++);
        ordemMap.put(ordem.getId(), ordem);
        AppImpressao.relatorio("Incluído a ordem: " + ordem.getId(), ordem);
    }

    public static Collection<Ordem> obterLista() {
        return ordemMap.values();
    }

    public static void excluir(Long id) {
        ordemMap.remove(id);
    }

    public static Ordem obterPorId(Long id) {
        return ordemMap.get(id);
    }

    public static void atualizar(Long id, Ordem ordem) {
        ordemMap.put(id, ordem);
        AppImpressao.relatorio("Atualizado a ordem: " + ordem.getId(), ordem);
    }

    @GetMapping("/ordens")
    public String listPage(Model model) {
        model.addAttribute("ordemList", obterLista());
        return "/ordem/listar_page";
    }

    @GetMapping("/ordem/adicionar")
    public String createPage(Model model) {
        model.addAttribute("ordem", new Ordem());
        model.addAttribute("pageTitle", "Adicionar Ordem");
        model.addAttribute("formAction", "/ordem/adicionar");
        return "/ordem/adicionar_page";
    }

    @PostMapping("/ordem/adicionar")
    public String create(@ModelAttribute("ordem") Ordem ordem) {
        incluir(ordem);
        return "redirect:/ordens";
    }

    @GetMapping("/ordem/{id}/atualizar")
    public String updatePage(@PathVariable(value = "id") Long id, HttpServletRequest req) {
        req.setAttribute("ordem", obterPorId(id));
        req.setAttribute("pageTitle", "Atualizar Ordem");
        req.setAttribute("formAction", "/ordem/" + id + "/atualizar");
        return "/ordem/atualizar_page";
    }

    @PostMapping("/ordem/{id}/atualizar")
    public String update(@PathVariable(value = "id") Long id, @ModelAttribute("ordem") Ordem ordem) {
        atualizar(id, ordem);
        return "redirect:/ordens";
    }

    @GetMapping("/ordem/{id}/excluir")
    public String deletePage(@PathVariable(value = "id") Long id) {
        excluir(id);
        System.out.println("Excluído item " + id);
        return "redirect:/ordens";
    }
}

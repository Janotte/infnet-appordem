package br.edu.infnet.appordem.controllers;

import br.edu.infnet.appordem.model.domain.Componente;
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
public class ComponenteController {

    private static Map<Long, Componente> componenteMap = new HashMap<>();
    private static Long id = 1L;

    public static void incluir(Componente componente) {
        componente.setId(id++);
        componenteMap.put(componente.getId(), componente);
        AppImpressao.relatorio("Incluído o componente: " + componente.getNome(), componente);
    }

    public static Collection<Componente> obterLista() {
        return componenteMap.values();
    }

    public static void excluir(Long id) {
        componenteMap.remove(id);
    }

    public static Componente obterPorId(Long id) {
        return componenteMap.get(id);
    }

    public static void atualizar(Long id, Componente componente) {
        componenteMap.put(id, componente);
        AppImpressao.relatorio("Atualizado o componente: " + componente.getNome(), componente);
    }

    @GetMapping("/componentes")
    public String listPage(Model model) {
        model.addAttribute("componenteList", obterLista());
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
        incluir(componente);
        return "redirect:/componentes";
    }

    @GetMapping("/componente/{id}/atualizar")
    public String updatePage(@PathVariable(value = "id") Long id, HttpServletRequest req) {
        req.setAttribute("componente", obterPorId(id));
        req.setAttribute("pageTitle", "Atualizar Componente");
        req.setAttribute("formAction", "/componente/" + id + "/atualizar");
        return "/componente/atualizar_page";
    }

    @PostMapping("/componente/{id}/atualizar")
    public String update(@PathVariable(value = "id") Long id, @ModelAttribute("componente") Componente componente) {
        atualizar(id, componente);
        return "redirect:/componentes";
    }

    @GetMapping("/componente/{id}/excluir")
    public String deletePage(@PathVariable(value = "id") Long id) {
        excluir(id);
        System.out.println("Excluído item " + id);
        return "redirect:/componentes";
    }
}

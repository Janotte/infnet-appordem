package br.edu.infnet.appordem.controller;

import br.edu.infnet.appordem.model.domain.Servico;
import br.edu.infnet.appordem.model.domain.Servico;
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
public class ServicoController {

    private static Map<Long, Servico> servicoMap = new HashMap<>();
    private static Long id = 1L;

    public static void incluir(Servico servico) {
        servico.setId(id++);
        servicoMap.put(servico.getId(), servico);
        AppImpressao.relatorio("Incluído o serviço: " + servico.getNome(), servico);
    }

    public static Collection<Servico> obterLista() {
        return servicoMap.values();
    }

    public static void excluir(Long id) {
        servicoMap.remove(id);
    }

    public static Servico obterPorId(Long id) {
        return servicoMap.get(id);
    }

    public static void atualizar(Long id, Servico servico) {
        servicoMap.put(id, servico);
        AppImpressao.relatorio("Atualizado o servico: " + servico.getNome(), servico);
    }

    @GetMapping("/servicos")
    public String listPage(Model model) {
        model.addAttribute("servicoList", obterLista());
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
        incluir(servico);
        return "redirect:/servicos";
    }

    @GetMapping("/servico/{id}/atualizar")
    public String updatePage(@PathVariable(value = "id") Long id, HttpServletRequest req) {
        req.setAttribute("servico", obterPorId(id));
        req.setAttribute("pageTitle", "Atualizar Serviço");
        req.setAttribute("formAction", "/servico/" + id + "/atualizar");
        return "/servico/atualizar_page";
    }

    @PostMapping("/servico/{id}/atualizar")
    public String update(@PathVariable(value = "id") Long id, @ModelAttribute("servico") Servico servico) {
        atualizar(id, servico);
        return "redirect:/servicos";
    }

    @GetMapping("/servico/{id}/excluir")
    public String deletePage(@PathVariable(value = "id") Long id) {
        excluir(id);
        System.out.println("Excluído item " + id);
        return "redirect:/servicos";
    }
}


package br.edu.infnet.appordem.controller;

import br.edu.infnet.appordem.model.domain.Licenca;
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
public class LicencaController {

    private static Map<Long, Licenca> licencaMap = new HashMap<>();
    private static Long id = 1L;

    public static void incluir(Licenca licenca) {
        licenca.setId(id++);
        licencaMap.put(licenca.getId(), licenca);
        AppImpressao.relatorio("Incluído o licenca: " + licenca.getNome(), licenca);
    }

    public static Collection<Licenca> obterLista() {
        return licencaMap.values();
    }

    public static void excluir(Long id) {
        licencaMap.remove(id);
    }

    public static Licenca obterPorId(Long id) {
        return licencaMap.get(id);
    }

    public static void atualizar(Long id, Licenca licenca) {
        licencaMap.put(id, licenca);
        AppImpressao.relatorio("Atualizado o licença: " + licenca.getNome(), licenca);
    }

    @GetMapping("/licencas")
    public String listPage(Model model) {
        model.addAttribute("licencaList", obterLista());
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
        incluir(licenca);
        return "redirect:/licencas";
    }

    @GetMapping("/licenca/{id}/atualizar")
    public String updatePage(@PathVariable(value = "id") Long id, HttpServletRequest req) {
        req.setAttribute("licenca", obterPorId(id));
        req.setAttribute("pageTitle", "Atualizar Licença");
        req.setAttribute("formAction", "/licenca/" + id + "/atualizar");
        return "/licenca/atualizar_page";
    }

    @PostMapping("/licenca/{id}/atualizar")
    public String update(@PathVariable(value = "id") Long id, @ModelAttribute("licenca") Licenca licenca) {
        atualizar(id, licenca);
        return "redirect:/licencas";
    }

    @GetMapping("/licenca/{id}/excluir")
    public String deletePage(@PathVariable(value = "id") Long id) {
        excluir(id);
        System.out.println("Excluído item " + id);
        return "redirect:/licencas";
    }
}

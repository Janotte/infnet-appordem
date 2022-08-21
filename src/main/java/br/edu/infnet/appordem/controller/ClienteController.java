package br.edu.infnet.appordem.controller;

import br.edu.infnet.appordem.model.domain.Cliente;
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
public class ClienteController {

    private static Map<Long, Cliente> clienteMap = new HashMap<>();
    private static Long id = 1L;

    public static void incluir(Cliente cliente) {
        cliente.setId(id++);
        clienteMap.put(cliente.getId(), cliente);
        AppImpressao.relatorio("Incluído o cliente: " + cliente.getNome(), cliente);
    }

    public static Collection<Cliente> obterLista() {
        return clienteMap.values();
    }

    public static void excluir(Long id) {
        clienteMap.remove(id);
    }

    public static Cliente obterPorId(Long id) {
        return clienteMap.get(id);
    }

    public static void atualizar(Long id, Cliente cliente) {
        clienteMap.put(id, cliente);
        AppImpressao.relatorio("Atualizado o cliente: " + cliente.getNome(), cliente);
    }

    @GetMapping("/clientes")
    public String listPage(Model model) {
        model.addAttribute("clienteList", obterLista());
        return "/cliente/listar_page";
    }

    @GetMapping("/cliente/adicionar")
    public String createPage(Model model) {
        model.addAttribute("cliente", new Cliente());
        model.addAttribute("pageTitle", "Adicionar Cliente");
        model.addAttribute("formAction", "/cliente/adicionar");
        return "/cliente/adicionar_page";
    }

    @PostMapping("/cliente/adicionar")
    public String create(@ModelAttribute("cliente") Cliente cliente) {
        incluir(cliente);
        return "redirect:/clientes";
    }

    @GetMapping("/cliente/{id}/atualizar")
    public String updatePage(@PathVariable(value = "id") Long id, HttpServletRequest req) {
        req.setAttribute("cliente", obterPorId(id));
        req.setAttribute("pageTitle", "Atualizar Cliente");
        req.setAttribute("formAction", "/cliente/" + id + "/atualizar");
        return "/cliente/atualizar_page";
    }

    @PostMapping("/cliente/{id}/atualizar")
    public String update(@PathVariable(value = "id") Long id, @ModelAttribute("cliente") Cliente cliente) {
        atualizar(id, cliente);
        return "redirect:/clientes";
    }

    @GetMapping("/cliente/{id}/excluir")
    public String deletePage(@PathVariable(value = "id") Long id) {
        excluir(id);
        System.out.println("Excluído item " + id);
        return "redirect:/clientes";
    }
}

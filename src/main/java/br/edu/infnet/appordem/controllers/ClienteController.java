package br.edu.infnet.appordem.controllers;

import br.edu.infnet.appordem.exceptions.CpfCnpjInvalidoException;
import br.edu.infnet.appordem.model.domain.Cliente;
import br.edu.infnet.appordem.services.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    @GetMapping("/clientes")
    public String listPage(Model model) {
        model.addAttribute("clienteList", clienteService.obterLista());
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
        try {
            clienteService.incluir(cliente);
        } catch (CpfCnpjInvalidoException e) {
            throw new CpfCnpjInvalidoException("");
        }
        return "redirect:/clientes";
    }

    @GetMapping("/cliente/{id}/atualizar")
    public String updatePage(@PathVariable(value = "id") Long id, HttpServletRequest req) {
        req.setAttribute("cliente", clienteService.obterPorId(id));
        req.setAttribute("pageTitle", "Atualizar Cliente");
        req.setAttribute("formAction", "/cliente/" + id + "/atualizar");
        return "/cliente/atualizar_page";
    }

    @PostMapping("/cliente/{id}/atualizar")
    public String update(@PathVariable(value = "id") Long id, @ModelAttribute("cliente") Cliente cliente) {
        clienteService.atualizar(id, cliente);
        return "redirect:/clientes";
    }

    @GetMapping("/cliente/{id}/excluir")
    public String deletePage(@PathVariable(value = "id") Long id) {
        clienteService.excluir(id);
        System.out.println("Excluído item " + id);
        return "redirect:/clientes";
    }
}

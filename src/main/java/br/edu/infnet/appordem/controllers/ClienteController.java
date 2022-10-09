package br.edu.infnet.appordem.controllers;

import br.edu.infnet.appordem.model.domain.Cliente;
import br.edu.infnet.appordem.model.domain.Mensagem;
import br.edu.infnet.appordem.model.domain.Usuario;
import br.edu.infnet.appordem.model.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    private Mensagem mensagem;

    @GetMapping("/clientes")
    public String listPage(Model model, @SessionAttribute("auth") Usuario usuario) {
        model.addAttribute("pageTitle", "Clientes");
        model.addAttribute("clienteList", clienteService.obterLista(usuario));
        model.addAttribute("mensagem", mensagem);
        return "/cliente/listar_clientes";
    }

    @GetMapping("/cliente/adicionar")
    public String createPage(Model model) {
        model.addAttribute("cliente", new Cliente());
        model.addAttribute("pageTitle", "Adicionar Cliente");
        model.addAttribute("formAction", "/cliente/adicionar");
        return "/cliente/adicionar_cliente";
    }

    @PostMapping("/cliente/adicionar")
    public String create(@ModelAttribute("cliente") Cliente cliente, @SessionAttribute("auth") Usuario usuario) {
        mensagem = new Mensagem();
        try {
            cliente.setUsuario(usuario);
            clienteService.incluir(cliente);
            mensagem.setTexto("Cliente criado com sucesso!");
            mensagem.setTipo("alert-success");
        } catch (Exception e) {
            mensagem.setTexto("Não é possível criar o cliente!");
            mensagem.setTipo("alert-danger");
        }
        return "redirect:/clientes";
    }

    @GetMapping("/cliente/{id}/atualizar")
    public String updatePage(@PathVariable(value = "id") Long id, HttpServletRequest req) {
        req.setAttribute("cliente", clienteService.obterPorId(id).get());
        req.setAttribute("pageTitle", "Atualizar Cliente");
        req.setAttribute("formAction", "/cliente/" + id + "/atualizar");
        return "/cliente/atualizar_cliente";
    }

    @PostMapping("/cliente/{id}/atualizar")
    public String update(@PathVariable(value = "id") Long id, @ModelAttribute("cliente") Cliente cliente, @SessionAttribute("auth") Usuario usuario) {
        mensagem = new Mensagem();
        try {
            cliente.setUsuario(usuario);
            clienteService.atualizar(id, cliente);
            mensagem.setTexto("Cliente atualizado com sucesso!");
            mensagem.setTipo("alert-success");
        } catch (Exception e) {
            mensagem.setTexto("Não é possível atualizar o cliente!");
            mensagem.setTipo("alert-danger");
        }
        return "redirect:/clientes";
    }

    @GetMapping("/cliente/{id}/excluir")
    public String deletePage(@PathVariable(value = "id") Long id) {
        mensagem = new Mensagem();
        try {
            clienteService.excluir(id);
            mensagem.setTexto("Cliente excluído com sucesso!");
            mensagem.setTipo("alert-success");
        } catch (Exception e) {
            mensagem.setTexto("Não é possível excluir o cliente!");
            mensagem.setTipo("alert-danger");
        }
        return "redirect:/clientes";
    }
}

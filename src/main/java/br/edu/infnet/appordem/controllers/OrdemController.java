package br.edu.infnet.appordem.controllers;

import br.edu.infnet.appordem.model.domain.Cliente;
import br.edu.infnet.appordem.model.domain.Mensagem;
import br.edu.infnet.appordem.model.domain.Ordem;
import br.edu.infnet.appordem.model.domain.Usuario;
import br.edu.infnet.appordem.model.service.ClienteService;
import br.edu.infnet.appordem.model.service.OrdemService;
import br.edu.infnet.appordem.model.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping
public class OrdemController {

    @Autowired
    private OrdemService ordemService;

    @Autowired
    private ClienteService clienteService;

    @Autowired
    ProdutoService produtoService;

    private Mensagem mensagem;

    @GetMapping("/ordens")
    public String listPage(Model model, @SessionAttribute("auth") Usuario usuario) {
        model.addAttribute("ordemList", ordemService.obterLista(usuario));
        model.addAttribute("pageTitle", "Ordens");
        model.addAttribute("mensagem", mensagem);
        return "/ordem/listar_ordens";
    }

    @GetMapping("/ordem/adicionar")
    public String createPage(Model model, @SessionAttribute("auth") Usuario usuario) {
        model.addAttribute("clienteList", clienteService.obterLista(usuario));
        model.addAttribute("produtoList", produtoService.obterLista(usuario));
        model.addAttribute("pageTitle", "Adicionar Ordem");
        model.addAttribute("formAction", "/ordem/adicionar");
        return "/ordem/adicionar_ordem";
    }

    @PostMapping("/ordem/adicionar")
    public String create(Ordem ordem, @SessionAttribute("auth") Usuario usuario) {
        mensagem = new Mensagem();
        try {
            ordem.setUsuario(usuario);
            ordemService.incluir(ordem);
            mensagem.setTexto("Ordem criada com sucesso!");
            mensagem.setTipo("alert-success");
        } catch (Exception e) {
            mensagem.setTexto("Não é possível criar a ordem!");
            mensagem.setTipo("alert-danger");
        }
        return "redirect:/ordens";
    }

    @GetMapping("/ordem/{id}/atualizar")
    public String updatePage(@PathVariable(value = "id") Long id, HttpServletRequest req, Model model, @SessionAttribute("auth") Usuario usuario) {
        model.addAttribute("clienteList", clienteService.obterLista(usuario));
        model.addAttribute("produtoList", produtoService.obterLista(usuario));
        req.setAttribute("ordem", ordemService.obterPorId(id).get());
        req.setAttribute("pageTitle", "Atualizar Ordem");
        req.setAttribute("formAction", "/ordem/" + id + "/atualizar");
        return "/ordem/atualizar_ordem";
    }

    @PostMapping("/ordem/{id}/atualizar")
    public String update(@PathVariable(value = "id") Long id, @ModelAttribute("ordem") Ordem ordem, @SessionAttribute("auth") Usuario usuario) {
        mensagem = new Mensagem();
        try {
            ordem.setUsuario(usuario);
            Cliente cliente = clienteService.obterPorId(ordem.getCliente().getId()).get();
            ordem.setCliente(cliente);
            ordemService.atualizar(id, ordem);
            mensagem.setTexto("Ordem atualizada com sucesso!");
            mensagem.setTipo("alert-success");
        } catch (Exception e) {
            mensagem.setTexto("Não é possível atualizar a ordem!");
            mensagem.setTipo("alert-danger");
        }
        return "redirect:/ordens";
    }

    @GetMapping("/ordem/{id}/excluir")
    public String deletePage(@PathVariable(value = "id") Long id) {
        mensagem = new Mensagem();
        try {
            ordemService.excluir(id);
            mensagem.setTexto("Ordem excluída com sucesso!");
            mensagem.setTipo("alert-success");
        } catch (Exception e) {
            mensagem.setTexto("Não é possível excluir a ordem!");
            mensagem.setTipo("alert-danger");
        }
        return "redirect:/ordens";
    }
}

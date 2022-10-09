package br.edu.infnet.appordem.controllers;

import br.edu.infnet.appordem.model.exceptions.EntidadeExistenteException;
import br.edu.infnet.appordem.model.domain.Componente;
import br.edu.infnet.appordem.model.domain.Mensagem;
import br.edu.infnet.appordem.model.domain.Usuario;
import br.edu.infnet.appordem.model.service.ComponenteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@Controller
public class ComponenteController {

    @Autowired
    private ComponenteService componenteService;

    private Mensagem mensagem;

    @GetMapping("/componentes")
    public String listPage(Model model, @SessionAttribute("auth") Usuario usuario) {
        model.addAttribute("pageTitle", "Componentes");
        model.addAttribute("componenteList", componenteService.obterLista(usuario));
        model.addAttribute("mensagem", mensagem);
        return "/componente/listar_componentes";
    }

    @GetMapping("/componente/adicionar")
    public String createPage(Model model) {
        model.addAttribute("componente", new Componente());
        model.addAttribute("pageTitle", "Adicionar Componente");
        model.addAttribute("formAction", "/componente/adicionar");
        return "/componente/adicionar_componente";
    }

    @PostMapping("/componente/adicionar")
    public String create(@ModelAttribute("componente") Componente componente, @SessionAttribute("auth") Usuario usuario) {
        mensagem = new Mensagem();
        try {
            if (componenteService.obterPorNome(componente.getNome(), usuario.getId()).isPresent()) {
                throw new EntidadeExistenteException(String.format("Já existe um componente com nome %s", componente.getNome()));
            }
            componente.setUsuario(usuario);
            componente.setCustoCompra(componente.calcularValorCusto());
            componente.setPrecoVenda(componente.calcularPrecoVenda());
            componenteService.incluir(componente, usuario);
            mensagem.setTexto("Componente criado com sucesso!");
            mensagem.setTipo("alert-success");
        } catch (EntidadeExistenteException e) {
            mensagem.setTexto(e.getMessage());
            mensagem.setTipo("alert-danger");
        } catch (Exception e) {
            mensagem.setTexto("Não é possível criar o componente!");
            mensagem.setTipo("alert-danger");
        }
        return "redirect:/componentes";
    }

    @GetMapping("/componente/{id}/atualizar")
    public String updatePage(@PathVariable(value = "id") Long id, HttpServletRequest req) {
        req.setAttribute("componente", componenteService.obterPorId(id).get());
        req.setAttribute("pageTitle", "Atualizar Componente");
        req.setAttribute("formAction", "/componente/" + id + "/atualizar");
        return "/componente/atualizar_componente";
    }

    @PostMapping("/componente/{id}/atualizar")
    public String update(@PathVariable(value = "id") Long id, @ModelAttribute("componente") Componente componente, @SessionAttribute("auth") Usuario usuario) {
        mensagem = new Mensagem();
        try {
            componente.setUsuario(usuario);
            componente.setCustoCompra(componente.calcularValorCusto());
            componente.setPrecoVenda(componente.calcularPrecoVenda());
            componenteService.atualizar(id, componente);
            mensagem.setTexto("Componente atualizado com sucesso!");
            mensagem.setTipo("alert-success");
        } catch (Exception e) {
            mensagem.setTexto("Não é possível atualizar o componente!");
            mensagem.setTipo("alert-danger");
        }
        return "redirect:/componentes";
    }

    @GetMapping("/componente/{id}/excluir")
    public String deletePage(@PathVariable(value = "id") Long id) {
        mensagem = new Mensagem();
        try {
            componenteService.excluir(id);
            mensagem.setTexto("Componente excluído com sucesso!");
            mensagem.setTipo("alert-success");
        } catch (Exception e) {
            mensagem.setTexto("Não é possível excluir o componente!");
            mensagem.setTipo("alert-danger");
        }
        return "redirect:/componentes";
    }
}
package br.edu.infnet.appordem.controllers;

import br.edu.infnet.appordem.model.domain.Mensagem;
import br.edu.infnet.appordem.model.domain.Usuario;
import br.edu.infnet.appordem.model.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.SessionAttribute;

@Controller
public class ProdutoController {

    @Autowired
    private ProdutoService produtoService;

    private Mensagem mensagem;

    @GetMapping("/produtos")
    public String listPage(Model model, @SessionAttribute("auth") Usuario usuario) {
        model.addAttribute("pageTitle", "Produtos");
        model.addAttribute("produtoList", produtoService.obterLista(usuario));
        model.addAttribute("mensagem", mensagem);
        return "/produto/listar_produtos";
    }

    @GetMapping("/produto/{id}/excluir")
    public String deletePage(@PathVariable(value = "id") Long id) {
        mensagem = new Mensagem();
        try {
            produtoService.excluir(id);
            mensagem.setTexto("Produto excluído com sucesso!");
            mensagem.setTipo("alert-success");
        } catch (Exception e) {
            mensagem.setTexto("Não é possível excluir o produto!");
            mensagem.setTipo("alert-danger");
        }
        return "redirect:/produtos";
    }
}

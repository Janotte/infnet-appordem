package br.edu.infnet.appordem.model.service;

import br.edu.infnet.appordem.model.domain.Produto;
import br.edu.infnet.appordem.model.domain.Usuario;
import br.edu.infnet.appordem.model.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProdutoService {

    @Autowired
    ProdutoRepository produtoRepository;

    public List<Produto> obterLista(Usuario usuario) {
        return produtoRepository.obterLista(usuario.getId());
    }

    public void excluir(Long id) {
        produtoRepository.deleteById(id);
    }

    public Optional<Produto> obterPorId(Long id) {
        return produtoRepository.findById(id);
    }
}

package br.edu.infnet.appordem.model.repository;

import br.edu.infnet.appordem.model.domain.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Long> {
    @Query("from Produto p where p.usuario.id = :usuario_id")
    List<Produto> obterLista(Long usuario_id);
}

package br.edu.infnet.appordem.model.repository;

import br.edu.infnet.appordem.model.domain.Componente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ComponenteRepository extends JpaRepository<Componente, Long> {

    @Query("from Componente reg where reg.usuario.id = :usuario_id")
    List<Componente> obterLista(Long usuario_id);

    @Query("from Componente reg where reg.nome = :componente_nome and reg.usuario.id = :usuario_id")
    Optional<Componente> obterPorNomeEUsuario(String componente_nome, Long usuario_id);
}

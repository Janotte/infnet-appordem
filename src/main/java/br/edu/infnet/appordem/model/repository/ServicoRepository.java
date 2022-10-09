package br.edu.infnet.appordem.model.repository;

import br.edu.infnet.appordem.model.domain.Servico;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ServicoRepository extends JpaRepository<Servico, Long> {
    @Query("from Servico reg where reg.usuario.id = :usuario_id")
    List<Servico> obterLista(Long usuario_id);

    @Query("from Servico reg where reg.nome = :servico_nome and reg.usuario.id = :usuario_id")
    Optional<Servico> obterPorNomeEUsuario(String servico_nome, Long usuario_id);
}
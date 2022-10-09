package br.edu.infnet.appordem.model.repository;

import br.edu.infnet.appordem.model.domain.Licenca;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface LicencaRepository extends JpaRepository<Licenca, Long> {

    @Query("from Licenca reg where reg.usuario.id = :usuario_id")
    List<Licenca> obterLista(Long usuario_id);

    @Query("from Licenca reg where reg.nome = :licenca_nome and reg.usuario.id = :usuario_id")
    Optional<Licenca> obterPorNomeEUsuario(String licenca_nome, Long usuario_id);
}

package br.edu.infnet.appordem.model.repository;

import br.edu.infnet.appordem.model.domain.Ordem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrdemRepository extends JpaRepository<Ordem, Long> {
    @Query("from Ordem o where o.usuario.id = :usuario_id")
    List<Ordem> obterLista(Long usuario_id);
}

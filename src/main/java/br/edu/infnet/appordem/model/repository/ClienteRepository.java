package br.edu.infnet.appordem.model.repository;

import br.edu.infnet.appordem.model.domain.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long> {
    @Query("from Cliente c where c.usuario.id = :usuario_id")
    List<Cliente> obterLista(Long usuario_id);
    Optional<Cliente> findByCpfCnpj(String cpfCnpj);
}

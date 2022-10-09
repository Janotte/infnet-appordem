package br.edu.infnet.appordem.model.service;

import br.edu.infnet.appordem.model.exceptions.CampoObrigatorioException;
import br.edu.infnet.appordem.model.exceptions.ClienteNuloException;
import br.edu.infnet.appordem.model.domain.Ordem;
import br.edu.infnet.appordem.model.exceptions.CpfCnpjInvalidoException;
import br.edu.infnet.appordem.model.domain.Usuario;
import br.edu.infnet.appordem.model.repository.OrdemRepository;
import br.edu.infnet.appordem.model.test.AppImpressao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.Collection;
import java.util.Optional;

@Service
public class OrdemService {

    @Autowired
    OrdemRepository ordemRepository;

    public void incluir(Ordem ordem) {
        try {
            ordemRepository.save(ordem);
            AppImpressao.relatorio("Incluído a ordem: " + ordem.getId(), ordem);
        } catch (CampoObrigatorioException | CpfCnpjInvalidoException | ClienteNuloException e) {
            System.out.println("[ERRO] - ORDEM: " + e.getMessage());
        }
    }

    public Collection<Ordem> obterLista() {
        return ordemRepository.findAll();
    }

    public Collection<Ordem> obterLista(Usuario usuario) {
        return ordemRepository.obterLista(usuario.getId());
    }

    public void excluir(Long id) {
        ordemRepository.deleteById(id);
    }

    public Optional<Ordem> obterPorId(Long id) {
        return ordemRepository.findById(id);
    }

    public void atualizar(Long id, Ordem ordem) {
        Optional<Ordem> ordemParaAtualizar = ordemRepository.findById(id);
        if (ordemParaAtualizar.isEmpty()) {
            throw new EntityNotFoundException(String.format("A ordem de id %s não foi encontrada", id));
        }
        try {
            ordemRepository.save(ordem);
            AppImpressao.relatorio("Atualizado a ordem: " + ordem.getId(), ordem);
        } catch (CampoObrigatorioException | CpfCnpjInvalidoException | ClienteNuloException e) {
            System.out.println("[ERRO] - ORDEM: " + e.getMessage());
        }
    }
}

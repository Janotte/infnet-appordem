package br.edu.infnet.appordem.model.service;

import br.edu.infnet.appordem.model.exceptions.ComponenteComNcmInvalidoException;
import br.edu.infnet.appordem.model.exceptions.EntidadeExistenteException;
import br.edu.infnet.appordem.model.exceptions.ValorNegativoException;
import br.edu.infnet.appordem.model.exceptions.ValorVendaInvalidoException;
import br.edu.infnet.appordem.model.domain.Componente;
import br.edu.infnet.appordem.model.domain.Usuario;
import br.edu.infnet.appordem.model.repository.ComponenteRepository;
import br.edu.infnet.appordem.model.test.AppImpressao;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.Collection;
import java.util.Optional;

@Service
public class ComponenteService {

    @Autowired
    ComponenteRepository componenteRepository;

    public void incluir(Componente componente, Usuario usuario) {
        try {
            if (componenteRepository.obterPorNomeEUsuario(componente.getNome(), usuario.getId()).isPresent()) {
                throw new EntidadeExistenteException(String.format("Já existe um componente com nome %s", componente.getNome()));
            }
            componenteRepository.save(componente);
            AppImpressao.relatorio("Incluído o componente: " + componente.getNome(), componente);
        } catch (ValorVendaInvalidoException | ValorNegativoException | ComponenteComNcmInvalidoException | EntidadeExistenteException e) {
            System.out.println("[ERRO] - COMPONENTE: " + e.getMessage());
        }
    }

    public Collection<Componente> obterLista() {
        return componenteRepository.findAll();
    }

    public Collection<Componente> obterLista(Usuario usuario) {
        return componenteRepository.obterLista(usuario.getId());
    }

    public void excluir(Long id) {
        componenteRepository.deleteById(id);
    }

    public Optional<Componente> obterPorId(Long id) {
        return componenteRepository.findById(id);
    }

    public Optional<Componente> obterPorNome(String nome, Long usuario_id) {
        return componenteRepository.obterPorNomeEUsuario(nome, usuario_id);
    }

    public void atualizar(Long id, Componente componente) {
        Optional<Componente> componenteParaAtualizar = componenteRepository.findById(id);
        if (componenteParaAtualizar.isEmpty()) {
            throw new EntityNotFoundException(String.format("O componente de id %s não foi encontrado", id));
        }
        try {
            BeanUtils.copyProperties(componente, componenteParaAtualizar.get(), "id");
            componenteRepository.save(componenteParaAtualizar.get());
            AppImpressao.relatorio("Incluído o componente: " + componente.getNome(), componente);
        } catch (ValorVendaInvalidoException | ValorNegativoException | ComponenteComNcmInvalidoException e) {
            System.out.println("[ERRO] - COMPONENTE: " + e.getMessage());
        }
    }
}
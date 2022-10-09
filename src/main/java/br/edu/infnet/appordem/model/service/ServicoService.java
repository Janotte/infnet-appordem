package br.edu.infnet.appordem.model.service;

import br.edu.infnet.appordem.model.domain.Servico;
import br.edu.infnet.appordem.model.domain.Usuario;
import br.edu.infnet.appordem.model.exceptions.*;
import br.edu.infnet.appordem.model.repository.ServicoRepository;
import br.edu.infnet.appordem.model.test.AppImpressao;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.Collection;
import java.util.Optional;

@Service
public class ServicoService {

    @Autowired
    ServicoRepository servicoRepository;

    public void incluir(Servico servico, Usuario usuario) {
        try {
            if (servicoRepository.obterPorNomeEUsuario(servico.getNome(), usuario.getId()).isPresent()) {
                throw new EntidadeExistenteException(String.format("Já existe um serviço com nome %s", servico.getNome()));
            }
            servicoRepository.save(servico);
            AppImpressao.relatorio("Incluído o serviço: " + servico.getNome(), servico);
        } catch (CampoObrigatorioException | ValorNegativoException | ValorVendaInvalidoException | ServicoComGarantiaInvalidaException e) {
            System.out.println("[ERRO] - SERVIÇO: " + e.getMessage());
        }

    }

    public Collection<Servico> obterLista() {
        return servicoRepository.findAll();
    }

    public Collection<Servico> obterLista(Usuario usuario) {
        return servicoRepository.obterLista(usuario.getId());
    }

    public void excluir(Long id) {
        servicoRepository.deleteById(id);
    }

    public Optional<Servico> obterPorId(Long id) {
        return servicoRepository.findById(id);
    }

    public void atualizar(Long id, Servico servico) {
        Optional<Servico> servicoParaAtualizar = servicoRepository.findById(id);
        if (servicoParaAtualizar.isEmpty()) {
            throw new EntityNotFoundException(String.format("O serviço de id %s não foi encontrado", id));
        }
        try {
            BeanUtils.copyProperties(servico, servicoParaAtualizar.get(), "id");
            servicoRepository.save(servicoParaAtualizar.get());
            AppImpressao.relatorio("Atualizado o serviço: " + servico.getNome(), servico);
        } catch (CampoObrigatorioException | ValorNegativoException | ValorVendaInvalidoException | ServicoComGarantiaInvalidaException e) {
            System.out.println("[ERRO] - SERVIÇO: " + e.getMessage());
        }
    }
}
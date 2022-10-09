package br.edu.infnet.appordem.model.service;

import br.edu.infnet.appordem.model.exceptions.EntidadeExistenteException;
import br.edu.infnet.appordem.model.exceptions.LicencaSemFabricanteException;
import br.edu.infnet.appordem.model.exceptions.ValorNegativoException;
import br.edu.infnet.appordem.model.exceptions.ValorVendaInvalidoException;
import br.edu.infnet.appordem.model.domain.Licenca;
import br.edu.infnet.appordem.model.domain.Usuario;
import br.edu.infnet.appordem.model.repository.LicencaRepository;
import br.edu.infnet.appordem.model.test.AppImpressao;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.Collection;
import java.util.Optional;

@Service
public class LicencaService {

    @Autowired
    LicencaRepository licencaRepository;

    public void incluir(Licenca licenca, Usuario usuario) {
        try {
            if (licencaRepository.obterPorNomeEUsuario(licenca.getNome(), usuario.getId()).isPresent()) {
                throw new EntidadeExistenteException(String.format("Já existe uma licença com nome %s", licenca.getNome()));
            }
            licencaRepository.save(licenca);
            AppImpressao.relatorio("Incluído a licença: " + licenca.getNome(), licenca);
        } catch (ValorNegativoException | ValorVendaInvalidoException | LicencaSemFabricanteException e) {
            System.out.println("[ERRO] - LICENÇA: " + e.getMessage());
        }
    }

    public Collection<Licenca> obterLista() {
        return licencaRepository.findAll();
    }

    public Collection<Licenca> obterLista(Usuario usuario) {
        return licencaRepository.obterLista(usuario.getId());
    }

    public void excluir(Long id) {
        licencaRepository.deleteById(id);
    }

    public Optional<Licenca> obterPorId(Long id) {
        return licencaRepository.findById(id);
    }

    public void atualizar(Long id, Licenca licenca) {
        Optional<Licenca> licencaParaAtualizar = licencaRepository.findById(id);
        if (licencaParaAtualizar.isEmpty()) {
            throw new EntityNotFoundException(String.format("A licença de id %s não foi encontrada", id));
        }
        try {
            BeanUtils.copyProperties(licenca, licencaParaAtualizar.get(), "id");
            licencaRepository.save(licencaParaAtualizar.get());
            AppImpressao.relatorio("Atualizado a licença: " + licenca.getNome(), licenca);
        } catch (ValorNegativoException | ValorVendaInvalidoException | LicencaSemFabricanteException e) {
            System.out.println("[ERRO] - LICENÇA: " + e.getMessage());
        }

    }
}

package br.edu.infnet.appordem.model.service;

import br.edu.infnet.appordem.model.exceptions.CampoObrigatorioException;
import br.edu.infnet.appordem.model.exceptions.CelularInvalidoException;
import br.edu.infnet.appordem.model.exceptions.CpfCnpjInvalidoException;
import br.edu.infnet.appordem.model.exceptions.EntidadeExistenteException;
import br.edu.infnet.appordem.model.domain.Usuario;
import br.edu.infnet.appordem.model.domain.Cliente;
import br.edu.infnet.appordem.model.repository.ClienteRepository;
import br.edu.infnet.appordem.model.test.AppImpressao;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.Collection;
import java.util.Optional;

@Service
public class ClienteService {

    @Autowired
    ClienteRepository clienteRepository;

    public void incluir(Cliente cliente) {
        try {
            if (clienteRepository.findByCpfCnpj(cliente.getCpfCnpj()).isPresent()) {
                throw new EntidadeExistenteException(String.format("Já existe um cliente com CPF ou CNPJ %s", cliente.getCpfCnpj()));
            }
            cliente.setCpfCnpj(formatarCpfCnpj(cliente.getCpfCnpj()));
            cliente.setCelular(formatarCelular(cliente.getCelular()));
            clienteRepository.save(cliente);
            AppImpressao.relatorio("Incluído o cliente: " + cliente.getNome(), cliente);
        } catch (CampoObrigatorioException | CpfCnpjInvalidoException e) {
            System.out.println("[ERRO] - CLIENTE: " + e.getMessage());
        }
    }

    public Collection<Cliente> obterLista() {
        return clienteRepository.findAll();
    }

    public Collection<Cliente> obterLista(Usuario usuario) {
        return clienteRepository.obterLista(usuario.getId());
    }

    public void excluir(Long id) {
        clienteRepository.deleteById(id);
    }

    public Optional<Cliente> obterPorId(Long id) {
        return clienteRepository.findById(id);
    }

    public void atualizar(Long id, Cliente cliente) {
        Optional<Cliente> clienteParaAtualizar = clienteRepository.findById(id);
        if (clienteParaAtualizar.isEmpty()) {
            throw new EntityNotFoundException(String.format("O cliente de id %s não foi encontrado.", id));
        }
        try {
            BeanUtils.copyProperties(cliente, clienteParaAtualizar.get(), "id");
            clienteRepository.save(clienteParaAtualizar.get());
            AppImpressao.relatorio("Atualizado o cliente: " + cliente.getNome(), cliente);
        } catch (CampoObrigatorioException | CpfCnpjInvalidoException e) {
            System.out.println("[ERRO] - CLIENTE: " + e.getMessage());
        }
    }

    public String formatarCpfCnpj(String cpfCnpj) {
        cpfCnpj = cpfCnpj.replaceAll("[^0-9]", "");
        if (cpfCnpj.length() == 11) {
            cpfCnpj = cpfCnpj.replaceAll("(\\d{3})(\\d{3})(\\d{3})(\\d{2})", "$1.$2.$3-$4");
        } else if (cpfCnpj.length() == 14) {
            cpfCnpj = cpfCnpj.replaceAll("(\\d{2})(\\d{3})(\\d{3})(\\d{4})(\\d{2})", "$1.$2.$3/$4-$5");
        } else {
            throw new CpfCnpjInvalidoException("O CPF ou CNPJ informado não é válido");
        }
        return cpfCnpj;
    }

    public String formatarCelular(String celular) {
        celular = celular.replaceAll("[^0-9]", "");
        if (celular.length() != 11) {
            throw new CelularInvalidoException("O número deve conter os dois dígitos do DDD e 9 dígitos do número");
        }
        celular = celular.replaceAll("(\\d{2})(\\d{5})(\\d{4})", "($1) $2-$3");
        return celular;
    }
}

package br.edu.infnet.appordem.model.services;

import br.edu.infnet.appordem.model.domain.Cliente;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Service
public class ClienteService {

    private static Map<Long, Cliente> clienteMap = new HashMap<>();
    private static Long id = 1L;

    public void incluir(Cliente cliente) {
        cliente.setId(id++);
        clienteMap.put(cliente.getId(), cliente);
        AppImpressao.relatorio("Incluído o cliente: " + cliente.getNome(), cliente);
    }

    public Collection<Cliente> obterLista() {
        return clienteMap.values();
    }

    public void excluir(Long id) {
        clienteMap.remove(id);
    }

    public Cliente obterPorId(Long id) {
        return clienteMap.get(id);
    }

    public void atualizar(Long id, Cliente cliente) {
        clienteMap.put(id, cliente);
        AppImpressao.relatorio("Atualizado o cliente: " + cliente.getNome(), cliente);
    }
}
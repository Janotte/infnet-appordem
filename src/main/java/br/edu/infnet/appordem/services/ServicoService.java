package br.edu.infnet.appordem.services;

import br.edu.infnet.appordem.model.domain.Servico;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Service
public class ServicoService {

    private static Map<Long, Servico> servicoMap = new HashMap<>();
    private static Long id = 1L;

    public void incluir(Servico servico) {
        servico.setId(id++);
        servicoMap.put(servico.getId(), servico);
        AppImpressao.relatorio("Incluído o serviço: " + servico.getNome(), servico);
    }

    public Collection<Servico> obterLista() {
        return servicoMap.values();
    }

    public void excluir(Long id) {
        servicoMap.remove(id);
    }

    public Servico obterPorId(Long id) {
        return servicoMap.get(id);
    }

    public void atualizar(Long id, Servico servico) {
        servicoMap.put(id, servico);
        AppImpressao.relatorio("Atualizado o serviço: " + servico.getNome(), servico);
    }
}

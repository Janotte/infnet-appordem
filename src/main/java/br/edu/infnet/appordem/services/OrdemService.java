package br.edu.infnet.appordem.services;

import br.edu.infnet.appordem.model.domain.Ordem;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Service
public class OrdemService {

    private static Map<Long, Ordem> ordemMap = new HashMap<>();
    private static Long id = 1L;

    public void incluir(Ordem ordem) {
        ordem.setId(id++);
        ordemMap.put(ordem.getId(), ordem);
        AppImpressao.relatorio("Incluído a ordem: " + ordem.getId(), ordem);
    }

    public Collection<Ordem> obterLista() {
        return ordemMap.values();
    }

    public void excluir(Long id) {
        ordemMap.remove(id);
    }

    public Ordem obterPorId(Long id) {
        return ordemMap.get(id);
    }

    public void atualizar(Long id, Ordem ordem) {
        ordemMap.put(id, ordem);
        AppImpressao.relatorio("Atualizado a ordem: " + ordem.getId(), ordem);
    }
}

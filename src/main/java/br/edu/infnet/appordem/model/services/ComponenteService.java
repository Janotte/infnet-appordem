package br.edu.infnet.appordem.model.services;

import br.edu.infnet.appordem.model.domain.Componente;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Service
public class ComponenteService {

    private static Map<Long, Componente> componenteMap = new HashMap<>();
    private static Long id = 1L;

    public void incluir(Componente componente) {
        componente.setId(id++);
        componenteMap.put(componente.getId(), componente);
        AppImpressao.relatorio("Incluído o componente: " + componente.getNome(), componente);
    }

    public Collection<Componente> obterLista() {
        return componenteMap.values();
    }

    public void excluir(Long id) {
        componenteMap.remove(id);
    }

    public Componente obterPorId(Long id) {
        return componenteMap.get(id);
    }

    public void atualizar(Long id, Componente componente) {
        componenteMap.put(id, componente);
        AppImpressao.relatorio("Atualizado o componente: " + componente.getNome(), componente);
    }
}

package br.edu.infnet.appordem.services;

import br.edu.infnet.appordem.model.domain.Licenca;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Service
public class LicencaService {

    private static Map<Long, Licenca> licencaMap = new HashMap<>();
    private static Long id = 1L;

    public void incluir(Licenca licenca) {
        licenca.setId(id++);
        licencaMap.put(licenca.getId(), licenca);
        AppImpressao.relatorio("Incluído a licença: " + licenca.getNome(), licenca);
    }

    public Collection<Licenca> obterLista() {
        return licencaMap.values();
    }

    public void excluir(Long id) {
        licencaMap.remove(id);
    }

    public Licenca obterPorId(Long id) {
        return licencaMap.get(id);
    }

    public void atualizar(Long id, Licenca licenca) {
        licencaMap.put(id, licenca);
        AppImpressao.relatorio("Atualizado a licença: " + licenca.getNome(), licenca);
    }
}

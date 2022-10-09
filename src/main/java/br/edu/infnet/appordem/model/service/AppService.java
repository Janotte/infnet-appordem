package br.edu.infnet.appordem.model.service;

import br.edu.infnet.appordem.model.app.Projeto;
import br.edu.infnet.appordem.model.test.AppImpressao;
import org.springframework.stereotype.Service;

@Service
public class AppService {

    private Projeto projeto;

    public void incluir(Projeto projeto) {
        this.projeto = projeto;

        AppImpressao.relatorio("Exibição do Projeto " + projeto.getNome() + " realizada com sucesso!!!", projeto);
    }

    public Projeto obterProjeto() {
        return projeto;
    }
}

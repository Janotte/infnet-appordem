package br.edu.infnet.appordem.services;

import br.edu.infnet.appordem.model.domain.app.Projeto;
import org.springframework.stereotype.Service;

@Service
public class AppService {

    private Projeto projeto;

    public void incluir(Projeto projeto) {
        this.projeto = projeto;

    }

    public Projeto obterProjeto() {
        return projeto;
    }
}

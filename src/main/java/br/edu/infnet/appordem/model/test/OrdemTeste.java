package br.edu.infnet.appordem.model.test;

import br.edu.infnet.appordem.model.domain.Ordem;
import br.edu.infnet.appordem.model.domain.Situacao;
import br.edu.infnet.appordem.model.domain.TipoAtendimento;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.Month;

@Component
@Order(1)
public class OrdemTeste implements ApplicationRunner {
    @Override
    public void run(ApplicationArguments args) throws Exception {

        System.out.println("\n# Ordem:");

        Ordem ordem1 = new Ordem();
        ordem1.setCodigo(1L);
        ordem1.setDataAbertura(LocalDateTime.of(2022, Month.AUGUST, 3, 9, 35, 57, 640000));
        ordem1.setSituacao(Situacao.CONCLUIDA);
        ordem1.setTipoAtendimento(TipoAtendimento.INTERNO);
        ordem1.setEquipamento("Notebook Samsung Book i7");
        ordem1.setProblema("Adicionar SSD NVME de 480Gb e reinstalar");
        ordem1.setSolucao("Backup, instalação do SSD e reinstalação do Windows");
        ordem1.setObservacao("Com carregador e mochila");
        System.out.println(ordem1);

        Ordem ordem6 = new Ordem();
        ordem6.setCodigo(2L);
        ordem6.setDataAbertura(LocalDateTime.of(2022, Month.AUGUST, 4, 7, 57, 35, 640000));
        ordem6.setSituacao(Situacao.ANALISE);
        ordem6.setTipoAtendimento(TipoAtendimento.EXTERNO);
        ordem6.setEquipamento("Servidor Dell Power Edge 9000");
        ordem6.setProblema("Não carrega o Windows");
        ordem6.setObservacao("Urgente, empresa sem acesso ao domínio local");
        System.out.println(ordem6);

        Ordem ordem3 = new Ordem();
        ordem3.setCodigo(3L);
        ordem3.setDataAbertura(LocalDateTime.of(2022, Month.AUGUST, 4, 8, 32, 28, 640000));
        ordem3.setSituacao(Situacao.ABERTA);
        ordem3.setTipoAtendimento(TipoAtendimento.REMOTO);
        ordem3.setEquipamento("CPU Dell Vostro");
        ordem3.setProblema("Não acesso a conectividade social");
        ordem3.setObservacao("Tem urgência");
        System.out.println(ordem3);
    }
}

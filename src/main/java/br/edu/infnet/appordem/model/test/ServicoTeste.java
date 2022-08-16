package br.edu.infnet.appordem.model.test;

import br.edu.infnet.appordem.model.domain.Servico;
import br.edu.infnet.appordem.model.domain.TipoServiço;
import br.edu.infnet.appordem.service.AppImpressao;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Order(5)
public class ServicoTeste implements ApplicationRunner {

    @Override
    public void run(ApplicationArguments args) throws Exception {

        System.out.println("\n### Serviços:");


        Servico servico1 = new Servico();
        servico1.setCodigo(1L);
        servico1.setTipoServico(TipoServiço.MANUTENCAO_SISTEMAS);
        servico1.setClassificacaoFiscal("1.07 – Suporte técnico em informática");
        servico1.setNome("Suporte técnico em sistemas");
        servico1.setCustoCompra(80.00);
        servico1.setPrecoVenda(servico1.calcularPrecoVenda());
        servico1.setGarantia("3 meses");

        AppImpressao.relatorio("Incluído o serviço: " + servico1.getNome(), servico1);

        Servico servico2 = new Servico();
        servico2.setCodigo(2L);
        servico2.setTipoServico(TipoServiço.MANUTENCAO_HARDWARE);
        servico2.setClassificacaoFiscal("14.02 – Assistência técnica");
        servico2.setNome("Suporte técnico em Servidores");
        servico2.setCustoCompra(70.00);
        servico2.setPrecoVenda(servico2.calcularPrecoVenda());
        servico2.setGarantia("Total");
        AppImpressao.relatorio("Incluído o serviço: " + servico2.getNome(), servico2);

        Servico servico3 = new Servico();
        servico3.setCodigo(3L);
        servico3.setTipoServico(TipoServiço.MANUTENCAO_INFRAESTRUTURA);
        servico3.setClassificacaoFiscal("14.02 – Assistência técnica");
        servico3.setNome("Montagem e manutenção de cabeamento de rede");
        servico3.setCustoCompra(80.00);
        servico3.setPrecoVenda(servico3.calcularPrecoVenda());
        servico3.setGarantia("Permanente");
        AppImpressao.relatorio("Incluído o serviço: " + servico3.getNome(), servico3);
    }
}

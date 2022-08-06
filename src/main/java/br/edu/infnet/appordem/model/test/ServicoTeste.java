package br.edu.infnet.appordem.model.test;

import br.edu.infnet.appordem.model.domain.Servico;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Order(5)
public class ServicoTeste implements ApplicationRunner {

    @Override
    public void run(ApplicationArguments args) throws Exception {

        System.out.println("\n# Serviço:");

        Servico servico1 = new Servico();
        servico1.setCodigo(1L);
        servico1.setNome("Serviço 1");
        servico1.setValor(120.00);
        servico1.setGarantia("90 dias");
        System.out.println(servico1);

        Servico servico2 = new Servico();
        servico2.setCodigo(2L);
        servico2.setNome("Serviço 2");
        servico2.setValor(1500.00);
        servico2.setGarantia("180 dias");
        System.out.println(servico2);

        Servico servico3 = new Servico();
        servico3.setCodigo(3L);
        servico3.setNome("Serviço 3");
        servico3.setValor(2500.00);
        servico3.setGarantia("360 dias");
        System.out.println(servico3);
    }
}

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

        Servico servico1 = new Servico(1L,"Serviço 1",120.00,"90 dias");
        System.out.println(servico1);

        Servico servico2 = new Servico(2L,"Serviço 2",1500.00,"180 dias");
        System.out.println(servico2);

        Servico servico3 = new Servico(3L,"Serviço 3",2500.00,"360 dias");
        System.out.println(servico3);
    }
}

package br.edu.infnet.appordem.model.test;

import br.edu.infnet.appordem.controller.ClienteController;
import br.edu.infnet.appordem.model.domain.Cliente;
import br.edu.infnet.appordem.service.AppImpressao;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Order(1)
public class ClienteTeste implements ApplicationRunner {

    @Override
    public void run(ApplicationArguments args) throws Exception {

        System.out.println("\n### Clientes:");

        Cliente cliente1 = new Cliente("Cliente 1","111.111.111-11","11111-1111","cliente1@exemplo.com");
        ClienteController.incluir(cliente1);

        Cliente cliente2 = new Cliente("Cliente 2","222.222.222-22","22222-2222","cliente2@exemplo.com");
        ClienteController.incluir(cliente2);

        Cliente cliente3 = new Cliente( "Cliente 3", "333.333.333-33", "33333-3333", "cliente3@exemplo.com");
        ClienteController.incluir(cliente3);
    }
}

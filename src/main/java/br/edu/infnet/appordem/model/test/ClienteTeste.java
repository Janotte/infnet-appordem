package br.edu.infnet.appordem.model.test;

import br.edu.infnet.appordem.model.domain.Cliente;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Order(2)
public class ClienteTeste implements ApplicationRunner {

    @Override
    public void run(ApplicationArguments args) throws Exception {

        System.out.println("\n### Clientes:");

        Cliente cliente1 = new Cliente(1L,"Cliente 1","111.111.111-11","11111-1111","cliente1@exemplo.com");
        AppImpressao.relatorio("Incluído o componente: " + cliente1.getNome(), cliente1);

        Cliente cliente2 = new Cliente(2L,"Cliente 2","222.222.222-22","22222-2222","cliente2@exemplo.com");
        AppImpressao.relatorio("Incluído o componente: " + cliente2.getNome(), cliente2);

        Cliente cliente3 = new Cliente(3L,"Cliente 3","333.333.333-33","33333-3333","cliente3@exemplo.com");
        AppImpressao.relatorio("Incluído o componente: " + cliente3.getNome(), cliente3);
    }
}

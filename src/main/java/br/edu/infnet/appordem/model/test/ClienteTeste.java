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

        System.out.println("\n# Cliente");

        Cliente cliente1 = new Cliente();
        cliente1.setCodigo(1L);
        cliente1.setNome("Cliente 1");
        cliente1.setCpfCnpj("111.111.111-11");
        cliente1.setCelular("11111-1111");
        cliente1.setEmail("cliente1@exemplo.com");
        System.out.println(cliente1);

        Cliente cliente2 = new Cliente();
        cliente2.setCodigo(2L);
        cliente2.setNome("Cliente 2");
        cliente2.setCpfCnpj("222.222.222-22");
        cliente2.setCelular("22222-2222");
        cliente2.setEmail("cliente2@exemplo.com");
        System.out.println(cliente2);

        Cliente cliente3 = new Cliente();
        cliente3.setCodigo(3L);
        cliente3.setNome("Cliente 3");
        cliente3.setCpfCnpj("333.333.333-33");
        cliente3.setCelular("33333-3333");
        cliente3.setEmail("cliente3@exemplo.com");
        System.out.println(cliente3);
    }
}

package br.edu.infnet.appordem.model.test;

import br.edu.infnet.appordem.model.domain.Componente;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Order(3)
public class ComponenteTeste implements ApplicationRunner {
    @Override
    public void run(ApplicationArguments args) throws Exception {

        System.out.println("\n# Componente:");

        Componente componente1 = new Componente();
        componente1.setCodigo(1L);
        componente1.setNcm("1111.11.11");
        componente1.setNome("Componente 1");
        componente1.setValor(100.00);
        System.out.println(componente1);

        Componente componente2 = new Componente();
        componente2.setCodigo(2L);
        componente2.setNcm("2222.22.22");
        componente2.setNome("Componente 2");
        componente2.setValor(200.00);
        System.out.println(componente2);

        Componente componente3 = new Componente();
        componente3.setCodigo(3L);
        componente3.setNcm("3333.33.33");
        componente3.setNome("Componente 3");
        componente3.setValor(300.00);
        System.out.println(componente3);
    }
}
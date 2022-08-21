package br.edu.infnet.appordem.model.test;

import br.edu.infnet.appordem.controller.ComponenteController;
import br.edu.infnet.appordem.model.domain.Componente;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Order(2)
public class ComponenteTeste implements ApplicationRunner {

    @Override
    public void run(ApplicationArguments args) throws Exception {

        System.out.println("\n### Componente");

        Componente componente1 = new Componente();
        componente1.setNome("Componente 1");
        componente1.setNcm("1111.11.11");
        componente1.setValorCompra(100.00);
        componente1.setValorFrete(10.00);
        componente1.setCustoCompra(componente1.calcularValorCusto());
        componente1.setPrecoVenda(componente1.calcularPrecoVenda());
        ComponenteController.incluir(componente1);

        Componente componente2 = new Componente();
        componente2.setNome("Componente 2");
        componente2.setNcm("2222.22.22");
        componente2.setValorCompra(200.00);
        componente2.setValorFrete(25.00);
        componente2.setCustoCompra(componente2.calcularValorCusto());
        componente2.setPrecoVenda(componente2.calcularPrecoVenda());
        ComponenteController.incluir(componente2);

        Componente componente3 = new Componente();
        componente3.setNome("Componente 3");
        componente3.setNcm("3333.33.33");
        componente3.setValorCompra(300.00);
        componente3.setValorFrete(20.00);
        componente3.setCustoCompra(componente3.calcularValorCusto());
        componente3.setPrecoVenda(componente3.calcularPrecoVenda());
        ComponenteController.incluir(componente3);
    }
}

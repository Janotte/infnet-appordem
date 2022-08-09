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

        System.out.println("\n# Componentes:");

        Componente componente1 = new Componente(1L,"Componente 1",100.00,"1111.11.11");
        componente1.impressao();

        Componente componente2 = new Componente(2L,"Componente 2",200.00,"2222.22.22");
        componente2.impressao();

        Componente componente3 = new Componente(3L,"Componente 3",300.00,"3333.33.33");
        componente3.impressao();
    }
}

package br.edu.infnet.appordem.model.test;

import br.edu.infnet.appordem.model.domain.Licenca;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Order(4)
public class LicencaTeste implements ApplicationRunner {
    @Override
    public void run(ApplicationArguments args) throws Exception {

        System.out.println("\n# Licenças:");

        Licenca licenca1 = new Licenca(1L,"Licença 1",76.91,"12 meses");
        licenca1.impressao();

        Licenca licenca2 = new Licenca(2L,"Licença 2",147.42,"24 meses");
        licenca2.impressao();

        Licenca licenca3 = new Licenca(3L,"Licença 3",324.76,"36 meses");
        licenca3.impressao();
    }
}

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

        System.out.println("\n# Licença:");

        Licenca licenca1 = new Licenca();
        licenca1.setCodigo(1L);
        licenca1.setValidade("12 meses");
        licenca1.setNome("Licença 1");
        licenca1.setValor(76.91);
        System.out.println(licenca1);

        Licenca licenca2 = new Licenca();
        licenca2.setCodigo(2L);
        licenca2.setValidade("24 meses");
        licenca2.setNome("Licença 2");
        licenca2.setValor(147.42);
        System.out.println(licenca2);

        Licenca licenca3 = new Licenca();
        licenca3.setCodigo(3L);
        licenca3.setValidade("36 meses");
        licenca3.setNome("Licença 3");
        licenca3.setValor(324.76);
        System.out.println(licenca3);
    }
}

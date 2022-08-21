package br.edu.infnet.appordem.model.test;

import br.edu.infnet.appordem.controller.LicencaController;
import br.edu.infnet.appordem.model.domain.Licenca;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Order(3)
public class LicencaTeste implements ApplicationRunner {

    @Override
    public void run(ApplicationArguments args) throws Exception {

        System.out.println("\n### Licenças:");

        Licenca licenca1 = new Licenca();
        licenca1.setNome("Licença 1");
        licenca1.setCustoCompra(76.91);
        licenca1.setPrecoVenda(licenca1.calcularPrecoVenda());
        licenca1.setQuantidadeDispositivos(1);
        licenca1.setValidade("12 meses");
        licenca1.setFabricante("Fabricante da Licença 1");
        LicencaController.incluir(licenca1);

        Licenca licenca2 = new Licenca();
        licenca2.setNome("Licença 2");
        licenca2.setCustoCompra(147.42);
        licenca2.setPrecoVenda(licenca2.calcularPrecoVenda());
        licenca2.setQuantidadeDispositivos(2);
        licenca2.setValidade("24 meses");
        licenca2.setFabricante("Fabricante da Licença 2");
        LicencaController.incluir(licenca2);

        Licenca licenca3 = new Licenca();
        licenca3.setNome("Licença 3");
        licenca3.setCustoCompra(324.76);
        licenca3.setPrecoVenda(licenca3.calcularPrecoVenda());
        licenca3.setQuantidadeDispositivos(5);
        licenca3.setValidade("36 meses");
        licenca3.setFabricante("Fabricante da Licença 3");
        LicencaController.incluir(licenca3);
    }
}

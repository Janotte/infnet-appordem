package br.edu.infnet.appordem.model.test;

import br.edu.infnet.appordem.model.domain.Licenca;
import br.edu.infnet.appordem.service.AppImpressao;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Order(4)
public class LicencaTeste implements ApplicationRunner {
    @Override
    public void run(ApplicationArguments args) throws Exception {

        System.out.println("\n### Licenças:");

        Licenca licenca1 = new Licenca();
        licenca1.setCodigo(1L);
        licenca1.setNome("Licença 1");
        licenca1.setCustoCompra(76.91);
        licenca1.setPrecoVenda(licenca1.calcularPrecoVenda());
        licenca1.setQuantidadeDispositivos(1);
        licenca1.setValidade("12 meses");
        licenca1.setFabricante("Fabricante do Produto 1");
        AppImpressao.relatorio("Incluído a licença: " + licenca1.getNome(), licenca1);

        Licenca licenca2 = new Licenca();
        licenca2.setCodigo(2L);
        licenca2.setNome("Licença 2");
        licenca2.setCustoCompra(147.42);
        licenca2.setPrecoVenda(licenca2.calcularPrecoVenda());
        licenca2.setQuantidadeDispositivos(2);
        licenca2.setValidade("24 meses");
        licenca2.setFabricante("Fabricante do Produto 2");
        AppImpressao.relatorio("Incluído a licença: " + licenca2.getNome(), licenca2);

        Licenca licenca3 = new Licenca();
        licenca3.setCodigo(3L);
        licenca3.setNome("Licença 3");
        licenca3.setCustoCompra(324.76);
        licenca3.setPrecoVenda(licenca3.calcularPrecoVenda());
        licenca3.setQuantidadeDispositivos(5);
        licenca3.setValidade("36 meses");
        licenca3.setFabricante("Fabricante do Produto 3");
        AppImpressao.relatorio("Incluído a licença: " + licenca3.getNome(), licenca3);
    }
}

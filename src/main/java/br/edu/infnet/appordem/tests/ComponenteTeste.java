package br.edu.infnet.appordem.tests;

import br.edu.infnet.appordem.controllers.ComponenteController;
import br.edu.infnet.appordem.exceptions.ComponenteComNcmInvalidoException;
import br.edu.infnet.appordem.exceptions.ValorVendaInvalidoException;
import br.edu.infnet.appordem.exceptions.ValorNegativoException;
import br.edu.infnet.appordem.model.domain.Componente;
import br.edu.infnet.appordem.services.ComponenteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

@Component
@Order(2)
public class ComponenteTeste implements ApplicationRunner {

    @Autowired
    private ComponenteService componenteService;

    @Override
    public void run(ApplicationArguments args) {

        System.out.println("\n### Componente");

        String dir = "C:/Pos2022/appordem/src/main/resources/";
        String arq = "componentes.txt";

        try {
            FileReader arquivo = new FileReader(dir + arq);
            BufferedReader leitura = new BufferedReader(arquivo);

            try {

                String linha = leitura.readLine();

                while (linha != null) {

                    try {
                        String[] campos = linha.split(";");

                        Componente componente = new Componente();
                        componente.setNome(campos[0]);
                        componente.setNcm(campos[1]);
                        componente.setValorCompra(Double.valueOf(campos[2]));
                        componente.setValorFrete(Double.valueOf(campos[3]));
                        componente.setCustoCompra(componente.calcularValorCusto());
                        componente.setPrecoVenda(componente.calcularPrecoVenda());

                        componenteService.incluir(componente);
                    } catch (ValorVendaInvalidoException | ValorNegativoException | ComponenteComNcmInvalidoException e) {
                        System.out.println("[ERRO] - COMPONENTE: " + e.getMessage());
                    }

                    linha = leitura.readLine();
                }

            } catch (FileNotFoundException e) {
                System.out.println("[ERRO] O arquivo não foi encontrado!");
            } finally {
                leitura.close();
                arquivo.close();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            System.out.println("[ERRO]" + e.getMessage());
        } finally {
            System.out.println("Leitura encerrada.");
        }
    }
}

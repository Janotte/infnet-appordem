package br.edu.infnet.appordem.tests;

import br.edu.infnet.appordem.controllers.ClienteController;
import br.edu.infnet.appordem.exceptions.CampoObrigatorioException;
import br.edu.infnet.appordem.exceptions.CpfCnpjInvalidoException;
import br.edu.infnet.appordem.model.domain.Cliente;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

@Component
@Order(1)
public class ClienteTeste implements ApplicationRunner {

    @Override
    public void run(ApplicationArguments args) {

        System.out.println("\n### Clientes:");

        String dir = "C:/Pos2022/appordem/src/main/resources/";
        String arq = "clientes.txt";

        try {
            FileReader arquivo = new FileReader(dir + arq);
            BufferedReader leitura = new BufferedReader(arquivo);

            try {

                String linha = leitura.readLine();

                while (linha != null) {

                    try {
                        String[] campos = linha.split(";");

                        Cliente cliente = new Cliente(campos[0], campos[1], campos[2], campos[3]);

                        ClienteController.incluir(cliente);
                    } catch (CampoObrigatorioException | CpfCnpjInvalidoException e) {
                        System.out.println("[ERRO] - CLIENTE: " + e.getMessage());
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

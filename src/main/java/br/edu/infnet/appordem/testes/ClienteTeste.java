package br.edu.infnet.appordem.testes;

import br.edu.infnet.appordem.model.domain.Cliente;
import br.edu.infnet.appordem.model.domain.Usuario;
import br.edu.infnet.appordem.model.exceptions.CampoObrigatorioException;
import br.edu.infnet.appordem.model.exceptions.CpfCnpjInvalidoException;
import br.edu.infnet.appordem.model.exceptions.EntidadeExistenteException;
import br.edu.infnet.appordem.model.service.ClienteService;
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
public class ClienteTeste implements ApplicationRunner {

    @Autowired
    private ClienteService clienteService;

    @Override
    public void run(ApplicationArguments args) {

        Usuario usuario = new Usuario();
        usuario.setId(1L);

        System.out.println("\n### Clientes:");
        String dir = "C:/Pos2022/appordem/src/main/resources/imports/";
        String arq = "clientes.txt";

        try {
            FileReader arquivo = new FileReader(dir + arq);
            BufferedReader leitura = new BufferedReader(arquivo);
            try {
                String linha = leitura.readLine();
                while (linha != null) {
                    String[] campos = linha.split(";");
                    try {
                        Cliente cliente = new Cliente(campos[0], campos[1], campos[2], campos[3]);
                        cliente.setUsuario(usuario);
                        clienteService.incluir(cliente);
                    } catch (CampoObrigatorioException | CpfCnpjInvalidoException | EntidadeExistenteException e) {
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
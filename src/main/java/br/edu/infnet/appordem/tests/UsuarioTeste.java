package br.edu.infnet.appordem.tests;

import br.edu.infnet.appordem.model.exceptions.CampoObrigatorioException;
import br.edu.infnet.appordem.model.domain.Usuario;
import br.edu.infnet.appordem.model.services.UsuarioService;
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
@Order(5)
public class UsuarioTeste implements ApplicationRunner {

    @Autowired
    private UsuarioService usuarioService;

    @Override
    public void run(ApplicationArguments args) throws Exception {

        System.out.println("\n### Usuários:");

        String dir = "C:/Pos2022/appordem/src/main/resources/";
        String arq = "usuarios.txt";

        try {
            FileReader arquivo = new FileReader(dir + arq);
            BufferedReader leitura = new BufferedReader(arquivo);

            try {

                String linha = leitura.readLine();

                while (linha != null) {

                    try {
                        String[] campos = linha.split(";");

                        Usuario usuario = new Usuario();
                        usuario.setEmail(campos[0]);
                        usuario.setNome(campos[1]);
                        usuario.setSenha(campos[2]);

                        usuarioService.incluir(usuario);
                    } catch (CampoObrigatorioException e) {
                        System.out.println("[ERRO] - USUÁRIO: " + e.getMessage());
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
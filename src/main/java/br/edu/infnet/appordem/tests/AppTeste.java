package br.edu.infnet.appordem.tests;

import br.edu.infnet.appordem.model.domain.app.Atributo;
import br.edu.infnet.appordem.model.domain.app.Classe;
import br.edu.infnet.appordem.model.domain.app.Projeto;
import br.edu.infnet.appordem.services.AppService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

@Component
@Order(7)
public class AppTeste implements ApplicationRunner {

    @Autowired
    private AppService appService;

    @Override
    public void run(ApplicationArguments args) throws Exception {

        System.out.println("\n### Projeto:");

        String dir = "C:/Pos2022/appordem/src/main/resources/";
        String arq = "app.txt";

        try {
            FileReader arquivo = new FileReader(dir + arq);
            BufferedReader leitura = new BufferedReader(arquivo);

            try {
                Projeto projeto = new Projeto();
                String linha = leitura.readLine();
                List<Classe> classes = new ArrayList<>();
                List<Atributo> atributos = new ArrayList<>();

                while (linha != null) {
                    String[] campos = linha.split(";");

                    switch (campos[0].toUpperCase()) {
                        case "P":
                            classes = new ArrayList<>();
                            projeto = new Projeto();
                            projeto.setNome(campos[1]);
                            projeto.setDescricao(campos[2]);
                            projeto.setClasses(classes);
                            break;
                        case "C":
                            atributos = new ArrayList<>();
                            Classe classe = new Classe();
                            classe.setNome(campos[1]);
                            classe.setAtributos(atributos);
                            classes.add(classe);
                            break;
                        case "A":
                            Atributo atributo = new Atributo(campos[1], campos[2], campos[3]);
                            atributos.add(atributo);
                            break;
                        default:
                            System.out.println("Opção inválida!!!");
                            break;
                    }

                    linha = leitura.readLine();
                }

                appService.incluir(projeto);

                leitura.close();
                arquivo.close();
            } catch (FileNotFoundException e) {
                System.out.println("[ERRO] O arquivo não foi encontrado!");
            }
        } finally {
            System.out.println("Leitura encerrada.");
        }
    }
}

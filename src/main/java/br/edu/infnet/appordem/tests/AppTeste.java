package br.edu.infnet.appordem.tests;

import br.edu.infnet.appordem.exceptions.CampoObrigatorioException;
import br.edu.infnet.appordem.exceptions.CpfCnpjInvalidoException;
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
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
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
                List<Classe> classeList = new ArrayList<>();
                List<Atributo> atributoList = new ArrayList<>();

                while (linha != null) {

                    try {
                        String[] campos = linha.split(";");


                        switch (campos[0].toUpperCase()) {
                            case "P":
                                classeList = new ArrayList<>();
                                projeto = new Projeto();
                                projeto.setNome(campos[1]);
                                projeto.setDescricao(campos[2]);
                                projeto.setClasses(classeList);
                                break;
                            case "C":
                                atributoList = new ArrayList<>();
                                Classe classe = new Classe();
                                classe.setNome(campos[1]);
                                classe.setAtributos(atributoList);
                                classeList.add(classe);
                                break;
                            case "A":
                                Atributo atributo = new Atributo(campos[1], campos[2], campos[3]);
                                atributoList.add(atributo);
                                break;
                            default:
                                break;
                        }

                        System.out.println(">>>> " + linha);
                        System.out.println(">>>> " + Arrays.asList(campos));


                    } catch (CampoObrigatorioException | CpfCnpjInvalidoException e) {
                        System.out.println("[ERRO] - CLIENTE: " + e.getMessage());
                    }

                    linha = leitura.readLine();
                }

                appService.incluir(projeto);

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

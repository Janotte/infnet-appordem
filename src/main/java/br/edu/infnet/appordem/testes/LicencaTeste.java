package br.edu.infnet.appordem.testes;

import br.edu.infnet.appordem.model.domain.Licenca;
import br.edu.infnet.appordem.model.domain.Usuario;
import br.edu.infnet.appordem.model.exceptions.EntidadeExistenteException;
import br.edu.infnet.appordem.model.exceptions.LicencaSemFabricanteException;
import br.edu.infnet.appordem.model.exceptions.ValorNegativoException;
import br.edu.infnet.appordem.model.exceptions.ValorVendaInvalidoException;
import br.edu.infnet.appordem.model.service.LicencaService;
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
@Order(4)
public class LicencaTeste implements ApplicationRunner {

    @Autowired
    private LicencaService licencaService;

    @Override
    public void run(ApplicationArguments args) {

        Usuario usuario = new Usuario();
        usuario.setId(1L);

        System.out.println("\n### Licenças:");
        String dir = "C:/Pos2022/appordem/src/main/resources/imports/";
        String arq = "produtos.txt";

        try {
            FileReader arquivo = new FileReader(dir + arq);
            BufferedReader leitura = new BufferedReader(arquivo);
            try {
                String linha = leitura.readLine();
                while (linha != null) {
                    String[] campos = linha.split(";");
                    try {
                        if (campos[0].toUpperCase().equals("L")) {
                            Licenca licenca = new Licenca();
                            licenca.setNome(campos[1]);
                            licenca.setCustoCompra(Double.valueOf(campos[2]));
                            licenca.setPrecoVenda(licenca.calcularPrecoVenda());
                            licenca.setQuantidadeDispositivos(Integer.valueOf(campos[3]));
                            licenca.setValidade(campos[4]);
                            licenca.setFabricante(campos[5]);
                            licenca.setUsuario(usuario);
                            licencaService.incluir(licenca, usuario);
                        }
                    } catch (ValorNegativoException | ValorVendaInvalidoException | LicencaSemFabricanteException | EntidadeExistenteException e) {
                        System.out.println("[ERRO] - LICENÇA: " + e.getMessage());
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
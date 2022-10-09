package br.edu.infnet.appordem.testes;

import br.edu.infnet.appordem.model.domain.Componente;
import br.edu.infnet.appordem.model.domain.Usuario;
import br.edu.infnet.appordem.model.exceptions.ComponenteComNcmInvalidoException;
import br.edu.infnet.appordem.model.exceptions.EntidadeExistenteException;
import br.edu.infnet.appordem.model.exceptions.ValorNegativoException;
import br.edu.infnet.appordem.model.exceptions.ValorVendaInvalidoException;
import br.edu.infnet.appordem.model.service.ComponenteService;
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
@Order(3)
public class ComponenteTeste implements ApplicationRunner {

    @Autowired
    private ComponenteService componenteService;

    @Override
    public void run(ApplicationArguments args) {

        Usuario usuario = new Usuario();
        usuario.setId(1L);

        System.out.println("\n### Componente");
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
                        if (campos[0].toUpperCase().equals("C")) {
                            Componente componente = new Componente();
                            componente.setNome(campos[1]);
                            componente.setNcm(campos[2]);
                            componente.setValorCompra(Double.valueOf(campos[3]));
                            componente.setValorFrete(Double.valueOf(campos[4]));
                            componente.setCustoCompra(componente.calcularValorCusto());
                            componente.setPrecoVenda(componente.calcularPrecoVenda());
                            componente.setUsuario(usuario);
                            componenteService.incluir(componente, usuario);
                        }
                    } catch (ValorVendaInvalidoException | ValorNegativoException | ComponenteComNcmInvalidoException | EntidadeExistenteException e) {
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
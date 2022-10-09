package br.edu.infnet.appordem.testes;

import br.edu.infnet.appordem.model.domain.Servico;
import br.edu.infnet.appordem.model.domain.TipoServico;
import br.edu.infnet.appordem.model.domain.Usuario;
import br.edu.infnet.appordem.model.exceptions.*;
import br.edu.infnet.appordem.model.service.ServicoService;
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
public class ServicoTeste implements ApplicationRunner {

    @Autowired
    private ServicoService servicoService;

    @Override
    public void run(ApplicationArguments args) throws Exception {

        Usuario usuario = new Usuario();
        usuario.setId(1L);

        System.out.println("\n### Serviços:");
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
                        if (campos[0].toUpperCase().equals("S")) {
                            Servico servico = new Servico();
                            servico.setTipoServico(TipoServico.valueOf(campos[1]));
                            servico.setClassificacaoFiscal(campos[2]);
                            servico.setNome(campos[3]);
                            servico.setCustoCompra(Double.valueOf(campos[4]));
                            servico.setPrecoVenda(servico.calcularPrecoVenda());
                            servico.setGarantia(campos[5]);
                            servico.setUsuario(usuario);
                            servicoService.incluir(servico, usuario);
                        }
                    } catch (CampoObrigatorioException | ValorNegativoException | ValorVendaInvalidoException | ServicoComGarantiaInvalidaException | EntidadeExistenteException e) {
                        System.out.println("[ERRO] - SERVIÇO: " + e.getMessage());
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

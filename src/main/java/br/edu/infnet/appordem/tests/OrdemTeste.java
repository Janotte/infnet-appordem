package br.edu.infnet.appordem.tests;

import br.edu.infnet.appordem.exceptions.CampoObrigatorioException;
import br.edu.infnet.appordem.exceptions.ClienteNuloException;
import br.edu.infnet.appordem.exceptions.CpfCnpjInvalidoException;
import br.edu.infnet.appordem.exceptions.OrdemSemProdutoException;
import br.edu.infnet.appordem.model.domain.*;
import br.edu.infnet.appordem.services.OrdemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.HashSet;
import java.util.Set;

@Component
@Order(6)
public class OrdemTeste implements ApplicationRunner {

    @Autowired
    private OrdemService ordemService;

    private FileReader arquivo;

    @Override
    public void run(ApplicationArguments args) throws Exception {

        System.out.println("\n### Ordens:");

        Componente componente = new Componente();
        componente.setId(1L);
        componente.setNome("SSD NVME 480Gb Corsair");
        componente.setNcm("1111.11.11");
        componente.setValorCompra(100.00);
        componente.setValorFrete(10.00);
        componente.setCustoCompra(componente.calcularValorCusto());
        componente.setPrecoVenda(componente.calcularPrecoVenda());

        Servico servico = new Servico();
        servico.setId(2L);
        servico.setTipoServico(TipoServico.MANUTENCAO_SISTEMAS);
        servico.setClassificacaoFiscal("1.07 – Suporte técnico em informática");
        servico.setNome("Suporte técnico em sistemas");
        servico.setCustoCompra(80.00);
        servico.setPrecoVenda(servico.calcularPrecoVenda());
        servico.setGarantia("3 meses");

        Licenca licenca = new Licenca();
        licenca.setId(3L);
        licenca.setNome("Antivirus ESET Internet Security");
        licenca.setCustoCompra(76.91);
        licenca.setPrecoVenda(licenca.calcularPrecoVenda());
        licenca.setQuantidadeDispositivos(1);
        licenca.setValidade("12 meses");
        licenca.setFabricante("ESET Brasil");

        ;

        String dir = "C:/Pos2022/appordem/src/main/resources/";
        String arq = "ordens.txt";

        try {
            FileReader arquivo = new FileReader(dir + arq);
            BufferedReader leitura = new BufferedReader(arquivo);

            try {

                String linha = leitura.readLine();

                while (linha != null) {

                    try {
                        String[] campos = linha.split(";");

                        Cliente cliente = new Cliente(campos[1], campos[2], campos[3], campos[4]);
                        cliente.setId(Long.valueOf(campos[0]));

                        Set<Produto> produtos = new HashSet<>();
                        produtos.add(componente);
                        produtos.add(licenca);
                        produtos.add(servico);

                        Ordem ordem = new Ordem(cliente, produtos);

                        ordem.setSituacao(Situacao.valueOf(campos[5]));
                        ordem.setTipoAtendimento(TipoAtendimento.valueOf(campos[6]));
                        ordem.setEquipamento(campos[7]);
                        ordem.setProblema(campos[8]);
                        ordem.setSolucao(campos[9]);
                        ordem.setObservacao(campos[10]);

                        ordemService.incluir(ordem);

                    } catch (CampoObrigatorioException | CpfCnpjInvalidoException | ClienteNuloException | OrdemSemProdutoException e) {
                        System.out.println("[ERRO] - ORDEM: " + e.getMessage());
                    }

                    linha = leitura.readLine();
                }

            } catch (FileNotFoundException e) {
                System.out.println("[ERRO] O arquivo não foi encontrado!");
            } catch (Exception e) {
                System.out.println("[ERRO]" + e.getMessage());
            } finally {
                leitura.close();
                arquivo.close();
            }
        } finally {
            System.out.println("Leitura encerrada.");
        }
    }
}

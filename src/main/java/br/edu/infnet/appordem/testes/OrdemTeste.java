package br.edu.infnet.appordem.testes;

import br.edu.infnet.appordem.model.domain.*;
import br.edu.infnet.appordem.model.exceptions.CampoObrigatorioException;
import br.edu.infnet.appordem.model.exceptions.ClienteNuloException;
import br.edu.infnet.appordem.model.exceptions.CpfCnpjInvalidoException;
import br.edu.infnet.appordem.model.service.ClienteService;
import br.edu.infnet.appordem.model.service.OrdemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Component
@Order(6)
public class OrdemTeste implements ApplicationRunner {

    @Autowired
    private OrdemService ordemService;

    @Autowired
    private ClienteService clienteService;

    @Override
    public void run(ApplicationArguments args) throws Exception {

        Usuario usuario = new Usuario();
        usuario.setId(1L);

        System.out.println("\n### Ordens:");
        String dir = "C:/Pos2022/appordem/src/main/resources/imports/";
        String arq = "ordens.txt";
        List<Ordem> ordens = new ArrayList<>();

        try {
            FileReader arquivo = new FileReader(dir + arq);
            BufferedReader leitura = new BufferedReader(arquivo);
            try {

                Set<Produto> produtos = null;
                Ordem ordem = null;
                String linha = leitura.readLine();

                while (linha != null) {
                    String[] campos = linha.split(";");
                    try {
                        switch (campos[0].toUpperCase()) {
                            case "O":
                                produtos = new HashSet<Produto>();
                                ordem = new Ordem(clienteService.obterPorId(Long.parseLong(campos[1])).get(), produtos);
                                ordem.setSituacao(Situacao.valueOf(campos[2]));
                                ordem.setTipoAtendimento(TipoAtendimento.valueOf(campos[3]));
                                ordem.setEquipamento(campos[4]);
                                ordem.setProblema(campos[5]);
                                ordem.setSolucao(campos[6]);
                                ordem.setObservacao(campos[7]);
                                ordem.setUsuario(usuario);
                                ordens.add(ordem);
                                break;
                            default:
                                break;
                        }
                    } catch (CampoObrigatorioException | CpfCnpjInvalidoException | ClienteNuloException e) {
                        System.out.println("[ERRO] - ORDEM: " + e.getMessage());
                    }
                    linha = leitura.readLine();
                }
                for (Ordem o : ordens) {
                    ordemService.incluir(o);
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
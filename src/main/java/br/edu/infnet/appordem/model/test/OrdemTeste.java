package br.edu.infnet.appordem.model.test;

import br.edu.infnet.appordem.controller.OrdemController;
import br.edu.infnet.appordem.model.domain.*;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;

@Component
@Order(5)
public class OrdemTeste implements ApplicationRunner {
    @Override
    public void run(ApplicationArguments args) throws Exception {

        System.out.println("\n### Ordens:");

        Componente componente1 = new Componente();
        componente1.setId(1L);
        componente1.setNome("Componente 1");
        componente1.setNcm("1111.11.11");
        componente1.setValorCompra(100.00);
        componente1.setValorFrete(10.00);
        componente1.setCustoCompra(componente1.calcularValorCusto());
        componente1.setPrecoVenda(componente1.calcularPrecoVenda());

        Componente componente2 = new Componente();
        componente2.setId(1L);
        componente2.setNome("Componente 2");
        componente2.setNcm("2222.22.22");
        componente2.setValorCompra(200.00);
        componente2.setValorFrete(25.00);
        componente2.setCustoCompra(componente2.calcularValorCusto());
        componente2.setPrecoVenda(componente2.calcularPrecoVenda());

        Licenca licenca1 = new Licenca();
        licenca1.setId(1L);
        licenca1.setNome("Licença 1");
        licenca1.setCustoCompra(76.91);
        licenca1.setPrecoVenda(licenca1.calcularPrecoVenda());
        licenca1.setQuantidadeDispositivos(1);
        licenca1.setValidade("12 meses");
        licenca1.setFabricante("Fabricante do Produto 1");

        Licenca licenca2 = new Licenca();
        licenca2.setId(2L);
        licenca2.setNome("Licença 2");
        licenca2.setCustoCompra(147.42);
        licenca2.setPrecoVenda(licenca2.calcularPrecoVenda());
        licenca2.setQuantidadeDispositivos(2);
        licenca2.setValidade("24 meses");
        licenca2.setFabricante("Fabricante do Produto 2");

        Servico servico1 = new Servico();
        servico1.setId(3L);
        servico1.setTipoServico(TipoServiço.MANUTENCAO_SISTEMAS);
        servico1.setClassificacaoFiscal("1.07 – Suporte técnico em informática");
        servico1.setNome("Suporte técnico em sistemas");
        servico1.setCustoCompra(80.00);
        servico1.setPrecoVenda(servico1.calcularPrecoVenda());
        servico1.setGarantia("3 meses");

        Set<Produto> produtoHashSet1 = new HashSet<>();
        produtoHashSet1.add(componente1);
        produtoHashSet1.add(componente2);

        Cliente cliente1 = new Cliente("Cliente 1", "111.111.111-11", "11111-1111", "cliente1@exemplo.com");
        Ordem ordem1 = new Ordem(cliente1);
        ordem1.setId(1L);
        ordem1.setSituacao(Situacao.CONCLUIDA);
        ordem1.setTipoAtendimento(TipoAtendimento.INTERNO);
        ordem1.setEquipamento("Notebook Samsung Book i7");
        ordem1.setProblema("Adicionar SSD NVME de 480Gb e reinstalar");
        ordem1.setSolucao("Backup, instalação do SSD e reinstalação do Windows");
        ordem1.setProdutos(produtoHashSet1);
        ordem1.setObservacao("Com carregador e mochila");
        OrdemController.incluir(ordem1);

        Set<Produto> produtoHashSet2 = new HashSet<>();
        produtoHashSet2.add(componente1);
        produtoHashSet2.add(componente2);
        produtoHashSet2.add(licenca1);
        produtoHashSet2.add(licenca2);

        Cliente cliente2 = new Cliente("Cliente 2", "222.222.222-22", "22222-2222", "cliente2@exemplo.com");
        Ordem ordem2 = new Ordem(cliente2);
        ordem2.setId(2L);
        ordem2.setSituacao(Situacao.ANALISE);
        ordem2.setTipoAtendimento(TipoAtendimento.EXTERNO);
        ordem2.setEquipamento("Servidor Dell Power Edge 9000");
        ordem2.setProblema("Não carrega o Windows");
        ordem2.setProdutos(produtoHashSet2);
        ordem2.setObservacao("Urgente, empresa sem acesso ao domínio local");
        OrdemController.incluir(ordem2);

        Set<Produto> produtoHashSet3 = new HashSet<>();
        produtoHashSet3.add(componente1);
        produtoHashSet3.add(componente2);
        produtoHashSet3.add(licenca1);
        produtoHashSet3.add(licenca2);
        produtoHashSet3.add(servico1);
        Cliente cliente3 = new Cliente("Cliente 3", "333.333.333-33", "33333-3333", "cliente3@exemplo.com");

        Ordem ordem3 = new Ordem(cliente3);
        ordem3.setSituacao(Situacao.ABERTA);
        ordem3.setTipoAtendimento(TipoAtendimento.REMOTO);
        ordem3.setEquipamento("CPU Dell Vostro");
        ordem3.setProblema("Não acesso a conectividade social");
        ordem3.setProdutos(produtoHashSet3);
        ordem3.setObservacao("Tem urgência");
        OrdemController.incluir(ordem3);
    }
}

package br.edu.infnet.appordem.model.domain;

import br.edu.infnet.appordem.exceptions.ClienteNuloException;
import br.edu.infnet.appordem.exceptions.OrdemSemProdutoException;
import br.edu.infnet.appordem.interfaces.IPrinter;

import java.util.Date;
import java.util.Set;

public class Ordem implements IPrinter {

    private Long id;
    private Date dataAbertura;
    private Situacao situacao;
    private TipoAtendimento tipoAtendimento;
    private Cliente cliente;
    private String equipamento;
    private String problema;
    private String solucao;
    private Set<Produto> produtos;
    private String observacao;

    public Ordem(Cliente cliente, Set<Produto> produtos) throws ClienteNuloException, OrdemSemProdutoException {

        if (cliente == null) throw new ClienteNuloException("Impossível criar uma Ordem sem um cliente!");

        if (produtos.size() < 1) throw new OrdemSemProdutoException("Impossível criar uma Ordem sem Produtos!");

        this.dataAbertura = new Date(System.currentTimeMillis());
        this.cliente = cliente;
        this.produtos = produtos;
    }

    public Ordem() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDataAbertura() {
        return dataAbertura;
    }

    public void setDataAbertura(Date dataAbertura) {
        this.dataAbertura = dataAbertura;
    }

    public Situacao getSituacao() {
        return situacao;
    }

    public void setSituacao(Situacao situacao) {
        this.situacao = situacao;
    }

    public TipoAtendimento getTipoAtendimento() {
        return tipoAtendimento;
    }

    public void setTipoAtendimento(TipoAtendimento tipoAtendimento) {
        this.tipoAtendimento = tipoAtendimento;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public String getEquipamento() {
        return equipamento;
    }

    public void setEquipamento(String equipamento) {
        this.equipamento = equipamento;
    }

    public String getProblema() {
        return problema;
    }

    public void setProblema(String problema) {
        this.problema = problema;
    }

    public String getSolucao() {
        return solucao;
    }

    public void setSolucao(String solucao) {
        this.solucao = solucao;
    }

    public Set<Produto> getProdutos() {
        return produtos;
    }

    public void setProdutos(Set<Produto> produtos) {
        this.produtos = produtos;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

    @Override
    public void imprimir() {
        System.out.println(this);
    }

    @Override
    public String toString() {
        return id + ";" + dataAbertura + ";" + situacao.getDescricao() + ";" + tipoAtendimento.getDescricao() + ";" + equipamento + ";" + problema + ";" + solucao + ";" + observacao + ";" + cliente;
    }
}

package br.edu.infnet.appordem.model.domain;

import br.edu.infnet.appordem.interfaces.IPrinter;

import java.time.LocalDateTime;
import java.util.Set;

public class Ordem implements IPrinter {

    private Long codigo;
    private LocalDateTime dataAbertura;
    private Situacao situacao;
    private TipoAtendimento tipoAtendimento;
    private Cliente cliente;
    private String equipamento;
    private String problema;
    private String solucao;
    private Set<Produto> produtos;
    private String observacao;

    public Ordem(Cliente cliente) {
        this.dataAbertura = LocalDateTime.now();
        this.cliente = cliente;
    }

    public Long getCodigo() {
        return codigo;
    }

    public void setCodigo(Long codigo) {
        this.codigo = codigo;
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
        return codigo + ";" + dataAbertura + ";" + situacao.getDescricao() + ";" + tipoAtendimento.getDescricao() + ";" + equipamento + ";" + problema + ";" + solucao + ";" + observacao + ";" + cliente + ";" + produtos.size();
    }
}

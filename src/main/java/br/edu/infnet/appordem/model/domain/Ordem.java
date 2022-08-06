package br.edu.infnet.appordem.model.domain;

import java.time.LocalDateTime;

public class Ordem {

    private Long codigo;
    private LocalDateTime dataAbertura;
    private Situacao situacao;
    private TipoAtendimento tipoAtendimento;
    private String equipamento;
    private String problema;
    private String solucao;
    private String observacao;

    public Long getCodigo() {
        return codigo;
    }

    public void setCodigo(Long codigo) {
        this.codigo = codigo;
    }

    public LocalDateTime getDataAbertura(LocalDateTime now) {
        return dataAbertura;
    }

    public void setDataAbertura(LocalDateTime dataAbertura) {
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

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

    @Override
    public String toString() {
        return codigo + ";" + dataAbertura + ";" + situacao.getDescricao() + ";" + tipoAtendimento.getDescricao() + ";" + equipamento + ";" + problema + ";" + solucao + ";" + observacao;
    }
}

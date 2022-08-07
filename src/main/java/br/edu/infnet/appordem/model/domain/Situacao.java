package br.edu.infnet.appordem.model.domain;

public enum Situacao {

    ABERTA("Aberta"),
    ANALISE("Em análise"),
    CONCLUIDA("Concluída");

    private final String descricao;

    Situacao(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }
}

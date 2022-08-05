package br.edu.infnet.appordem.model.domain;

public enum Situacao {

    ABERTA("Aberta"),
    ANALISE("Em análise"),
    CONCLUIDA("Concluída");

    private String descricao;

    Situacao(String descricao) {
        this.descricao = descricao;
    }
}

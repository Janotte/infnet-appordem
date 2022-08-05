package br.edu.infnet.appordem.model.domain;

public enum Funcao {

    ADMINISTRADOR("Administrador"),
    RECEPCIONISTA("Recepcionista"),
    TECNICO("Técnico");

    private final String descricao;

    Funcao(String descricao) {
        this.descricao = descricao;
    }
}

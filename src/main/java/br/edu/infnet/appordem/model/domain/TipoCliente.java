package br.edu.infnet.appordem.model.domain;

public enum TipoCliente {

    VIP("VIP"),
    NORMAL("Normal");

    private final String descricao;

    TipoCliente(String descricao) {
        this.descricao = descricao;
    }
}

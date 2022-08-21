package br.edu.infnet.appordem.model.domain;

public enum TipoAtendimento {

    INTERNO("Interno"),
    REMOTO("Remoto"),
    EXTERNO("Remoto");

    private final String descricao;

    TipoAtendimento(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }

}

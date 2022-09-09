package br.edu.infnet.appordem.model.domain;

public enum TipoServico {

    MANUTENCAO_SISTEMAS("Manutenção de Sistemas Operacionais e Aplicativos"),
    MANUTENCAO_HARDWARE("Manutenção de Hardware"),
    MANUTENCAO_INFRAESTRUTURA("Manutenção de Infraestrutura de rede");

    private String descricao;

    TipoServico(String descricao) {
        this.descricao = descricao;
    }
}

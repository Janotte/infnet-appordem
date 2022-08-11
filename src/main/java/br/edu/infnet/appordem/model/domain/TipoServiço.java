package br.edu.infnet.appordem.model.domain;

public enum TipoServiço {

    MANUTENCAO_SISTEMAS("Manutenção de Sistemas Operacionais e Aplicativos"),
    MANUTENCAO_HARDWARE("Manutenção de Hardware"),
    MANUTENCAO_INFRAESTRUTURA("Manutenção de Infraestrutura de rede");

    private String descrição;

    TipoServiço(String descrição) {
        this.descrição = descrição;
    }
}

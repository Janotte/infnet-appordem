package br.edu.infnet.appordem.model.domain;

public class Componente extends Produto {

    private String ncm;

    public String getNcm() {
        return ncm;
    }

    public void setNcm(String ncm) {
        this.ncm = ncm;
    }

    @Override
    public String toString() {
        return super.toString() + ";" + ncm;
    }
}

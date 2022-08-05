package br.edu.infnet.appordem.model.domain;

public class Servico extends Produto {

    private String garantia;

    public String getGarantia() {
        return garantia;
    }

    public void setGarantia(String garantia) {
        this.garantia = garantia;
    }

    @Override
    public String toString() {
        return "Servico{" +
                super.toString() + '\'' +
                "garantia='" + garantia + '\'' +
                '}';
    }
}

package br.edu.infnet.appordem.model.domain;

public class Licenca extends Produto {

    private String validade;

    public String getValidade() {
        return validade;
    }

    public void setValidade(String validade) {
        this.validade = validade;
    }

    @Override
    public String toString() {
        return super.toString() + ";" + validade;
    }
}

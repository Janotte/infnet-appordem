package br.edu.infnet.appordem.model.domain;

public class Servico extends Produto {

    private String garantia;

    public Servico(Long codigo, String nome, Double valor, String garantia) {
        super(codigo, nome, valor);
        this.garantia = garantia;
    }

    @Override
    public String toString() {
        return super.toString() + ";" + garantia;
    }
}

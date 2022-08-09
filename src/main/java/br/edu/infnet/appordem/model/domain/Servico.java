package br.edu.infnet.appordem.model.domain;

public class Servico extends Produto {

    private String garantia;

    public Servico(Long codigo, String nome, Double valor, String garantia) {
        super(codigo, nome, valor);
        this.garantia = garantia;
    }

    @Override
    public void impressao() {
        System.out.println("# Serviço");
        System.out.println(this);
    }

    @Override
    public String toString() {
        return super.toString() + ";" + garantia;
    }
}

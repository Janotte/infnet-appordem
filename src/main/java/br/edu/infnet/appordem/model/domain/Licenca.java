package br.edu.infnet.appordem.model.domain;

public class Licenca extends Produto {

    private String validade;

    public Licenca(Long codigo, String nome, Double valor, String validade) {
        super(codigo, nome, valor);
        this.validade = validade;
    }

    @Override
    public String toString() {
        return super.toString() + ";" + validade;
    }
}

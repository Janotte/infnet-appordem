package br.edu.infnet.appordem.model.domain;

public class Componente extends Produto {

    private String ncm;

    public Componente(Long codigo, String nome, Double valor, String ncm) {
        super(codigo, nome, valor);
        this.ncm = ncm;
    }

    @Override
    public void impressao() {
        System.out.println("# Componente");
        System.out.println(this);
    }

    @Override
    public String toString() {
        return super.toString() + ";" + ncm;
    }
}

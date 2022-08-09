package br.edu.infnet.appordem.model.domain;

public abstract class Produto {

    private Long codigo;
    private String nome;
    private Double valor;
    private Double custo;

    public Produto(Long codigo, String nome, Double valor) {
        this.codigo = codigo;
        this.nome = nome;
        this.valor = valor;
    }

    public double calcularValor() {
        return valor / .7;
    }

    public abstract void impressao();

    @Override
    public String toString() {
        return codigo + ";" + nome + ";" + valor + ";" + calcularValor();
    }
}

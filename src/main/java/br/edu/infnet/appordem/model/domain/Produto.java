package br.edu.infnet.appordem.model.domain;

public abstract class Produto {

    private Long codigo;
    private String nome;
    private Double valor;

    public Produto(Long codigo, String nome, Double valor) {
        this.codigo = codigo;
        this.nome = nome;
        this.valor = valor;
    }

    @Override
    public String toString() {
        return codigo + ";" + nome + ";" + valor;
    }
}

package br.edu.infnet.appordem.model.domain;

public abstract class Produto {

    private Long codigo;
    private String nome;
    private Double valor;

    public Long getCodigo() {
        return codigo;
    }

    public void setCodigo(Long codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    @Override
    public String toString() {
        return codigo + ";" + nome + ";" + valor;
    }
}
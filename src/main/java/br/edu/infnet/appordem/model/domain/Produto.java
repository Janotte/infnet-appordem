package br.edu.infnet.appordem.model.domain;

import br.edu.infnet.appordem.interfaces.IPrinter;

import java.util.Objects;

public abstract class Produto implements IPrinter {

    private Long id;
    private String nome;
    private Double custoCompra;
    private Double precoVenda;

    public abstract double calcularPrecoVenda();

    public void imprimir() {
        System.out.println(this);
    }

    @Override
    public String toString() {
        return id + ";" + nome + ";" + custoCompra + ";" + precoVenda;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Double getCustoCompra() {
        return custoCompra;
    }

    public void setCustoCompra(Double custoCompra) {
        this.custoCompra = custoCompra;
    }

    public Double getPrecoVenda() {
        return precoVenda;
    }

    public void setPrecoVenda(Double precoVenda) {
        this.precoVenda = precoVenda;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
    //    if (o == null || getClass() != o.getClass()) return false;
        Produto produto = (Produto) o;
        return Objects.equals(id, produto.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}

package br.edu.infnet.appordem.model.domain;

import br.edu.infnet.appordem.model.exceptions.ValorVendaInvalidoException;
import br.edu.infnet.appordem.interfaces.IPrinter;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Objects;


public abstract class Produto implements IPrinter {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "nome", length = 60, nullable = false)
    private String nome;

    @Column(name = "custo_compra", nullable = false)
    private Double custoCompra;

    @Column(name = "preco_venda", nullable = false)
    private Double precoVenda;

    public abstract double calcularPrecoVenda() throws ValorVendaInvalidoException;

    public void imprimir() {
        System.out.println(this);
    }

    @Override
    public String toString() {
        return id + ";" + nome + ";" + custoCompra;
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
        Produto produto = (Produto) o;
        return Objects.equals(id, produto.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}

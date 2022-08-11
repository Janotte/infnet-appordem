package br.edu.infnet.appordem.model.domain;

import br.edu.infnet.appordem.interfaces.IPrinter;

public abstract class Produto implements IPrinter {

    private Long codigo;
    private String nome;
    private Double custoCompra;
    private Double precoVenda;

    public abstract double calcularPrecoVenda();

    public void imprimir() {
        System.out.println(this);
    }

    @Override
    public String toString() {
        return codigo + ";" + nome + ";" + custoCompra + ";" + precoVenda;
    }


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
}

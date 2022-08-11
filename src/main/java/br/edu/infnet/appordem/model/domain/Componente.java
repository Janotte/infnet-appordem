package br.edu.infnet.appordem.model.domain;

public class Componente extends Produto {

    private String ncm;
    private Double valorCompra;
    private Double valorFrete;

    public String getNcm() {
        return ncm;
    }

    public void setNcm(String ncm) {
        this.ncm = ncm;
    }

    public Double getValorCompra() {
        return valorCompra;
    }

    public void setValorCompra(Double valorCompra) {
        this.valorCompra = valorCompra;
    }

    public Double getValorFrete() {
        return valorFrete;
    }

    public void setValorFrete(Double valorFrete) {
        this.valorFrete = valorFrete;
    }

    public double calcularValorCusto() {
        return valorCompra + valorFrete;
    }

    @Override
    public double calcularPrecoVenda() {
        return getCustoCompra() / 0.7;
    }

    @Override
    public void imprimir() {
        System.out.println(this);
    }

    @Override
    public String toString() {
        return super.toString() + ";" + ncm + ";" + valorCompra + ";" + valorFrete;
    }


}

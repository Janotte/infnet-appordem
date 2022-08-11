package br.edu.infnet.appordem.model.domain;

public class Licenca extends Produto {

    private int quantidadeDispositivos;
    private String validade;
    private String fabricante;

    public int getQuantidadeDispositivos() {
        return quantidadeDispositivos;
    }

    public void setQuantidadeDispositivos(int quantidadeDispositivos) {
        this.quantidadeDispositivos = quantidadeDispositivos;
    }

    public String getValidade() {
        return validade;
    }

    public void setValidade(String validade) {
        this.validade = validade;
    }

    public String getFabricante() {
        return fabricante;
    }

    public void setFabricante(String fabricante) {
        this.fabricante = fabricante;
    }

    @Override
    public double calcularPrecoVenda() {
        return getCustoCompra() * 2;
    }

    @Override
    public void imprimir() {
        System.out.println(this);
    }

    @Override
    public String toString() {
        return super.toString() + ";" + quantidadeDispositivos + ";" + validade + ";" + fabricante;
    }

}

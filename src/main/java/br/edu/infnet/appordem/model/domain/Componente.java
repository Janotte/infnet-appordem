package br.edu.infnet.appordem.model.domain;

import br.edu.infnet.appordem.exceptions.ComponenteComNcmInvalidoException;
import br.edu.infnet.appordem.exceptions.ValorNegativoException;
import br.edu.infnet.appordem.exceptions.ValorVendaInvalidoException;

public class Componente extends Produto {

    private String ncm;
    private Double valorCompra;
    private Double valorFrete;

    public String getNcm() {
        return ncm;
    }

    public void setNcm(String ncm) throws ComponenteComNcmInvalidoException {

        ncm = ncm.replaceAll("[^0-9]","");

        if (ncm.length() != 8 ) {
            throw new ComponenteComNcmInvalidoException("O NCM deve conter 8 dígitos.");
        }

        ncm = ncm.replaceAll("(\\d{4})(\\d{2})(\\d{2})", "$1.$2.$3");

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

        if (valorFrete < 0) throw new ValorNegativoException("O valor do frete do componente não pode ser negativo.");

        if (valorCompra < 0) throw new ValorNegativoException("O valor do compra do componente não pode ser negativo.");

        return valorCompra + valorFrete;
    }

    public double calcularPrecoVenda() throws ValorVendaInvalidoException {

        Double valor = getCustoCompra() / 0.7;

        if (valor <= 1.00) throw new ValorVendaInvalidoException("O valor de venda do componente não pode ser menor que 1.00.");

        return valor;
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

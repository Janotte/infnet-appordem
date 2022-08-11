package br.edu.infnet.appordem.model.domain;

public class Servico extends Produto {

    private String garantia;
    private TipoServiço tipoServico;
    private String classificacaoFiscal;

    public String getGarantia() {
        return garantia;
    }

    public void setGarantia(String garantia) {
        this.garantia = garantia;
    }

    public TipoServiço getTipoServico() {
        return tipoServico;
    }

    public void setTipoServico(TipoServiço tipoServico) {
        this.tipoServico = tipoServico;
    }

    public String getClassificacaoFiscal() {
        return classificacaoFiscal;
    }

    public void setClassificacaoFiscal(String classificacaoFiscal) {
        this.classificacaoFiscal = classificacaoFiscal;
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
        return super.toString() + ";" + garantia + ";" + tipoServico + ";" + classificacaoFiscal;
    }
}

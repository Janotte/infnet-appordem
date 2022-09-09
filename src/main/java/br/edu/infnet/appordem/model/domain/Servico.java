package br.edu.infnet.appordem.model.domain;

import br.edu.infnet.appordem.exceptions.ServicoComGarantiaInvalidaException;
import br.edu.infnet.appordem.exceptions.ValorNegativoException;
import br.edu.infnet.appordem.exceptions.ValorVendaInvalidoException;

public class Servico extends Produto {

    private String garantia;
    private TipoServico tipoServico;
    private String classificacaoFiscal;

    public String getGarantia() {
        return garantia;
    }

    public void setGarantia(String garantia) throws ServicoComGarantiaInvalidaException {
            String[] campos = garantia.split(" ");

            float tempo = Float.parseFloat(campos[0]);
            var periodo = campos[1];

            if (periodo.toLowerCase().contains("ano") && tempo < 1)
                throw new ServicoComGarantiaInvalidaException("O tempo mínimo para garantia em anos é 1 ano.");

            if (periodo.toLowerCase().contains("mes") && tempo < 3)
                throw new ServicoComGarantiaInvalidaException("O tempo mínimo para garantia em meses é 3 meses.");

            if (periodo.toLowerCase().contains("dia") && tempo < 90)
                throw new ServicoComGarantiaInvalidaException("O tempo mínimo para garantia em dias é 90 dias.");

        this.garantia = garantia;
    }

    public TipoServico getTipoServico() {
        return tipoServico;
    }

    public void setTipoServico(TipoServico tipoServico) {
        this.tipoServico = tipoServico;
    }

    public String getClassificacaoFiscal() {
        return classificacaoFiscal;
    }

    public void setClassificacaoFiscal(String classificacaoFiscal) {
        this.classificacaoFiscal = classificacaoFiscal;
    }

    @Override
    public double calcularPrecoVenda() throws ValorVendaInvalidoException {

        double valor = getCustoCompra() * 2.5;

        if (getCustoCompra() < 0)
            throw new ValorNegativoException("O custo de compra do serviço não pode ser negativo.");

        if (valor <= 100.00)
            throw new ValorVendaInvalidoException("O valor de venda do serviço não pode ser menor que 100.00.");

        return getCustoCompra() * 2.5;
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

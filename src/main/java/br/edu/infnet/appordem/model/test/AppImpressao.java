package br.edu.infnet.appordem.model.test;

import br.edu.infnet.appordem.interfaces.IPrinter;

public class AppImpressao {

    public static void relatorio(String mensagem, IPrinter printer) {
        System.out.println(mensagem);

        printer.imprimir();
    }
}
package br.com.sistemacompras.pagamento;

public class Pix implements Pagamento{

    @Override
    public boolean pagar(double valor) {
        System.out.printf("Pagamento via Pix realizado: R$%.2f%n", valor);
        return true;
    }
}

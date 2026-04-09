package br.com.sistemacompras.pagamento;

public class Cartao implements Pagamento{

    private boolean parcelado;
    private int numeroParcelas;

    public Cartao(boolean parcelado, int numeroParcelas) {
        this.parcelado = parcelado;

        if (parcelado) {
            if (numeroParcelas < 2 || numeroParcelas > 6) {
                throw new IllegalArgumentException("Parcelamento deve ser entre 2 a 6 vezes.");
            }
            this.numeroParcelas = numeroParcelas;
        } else {
            this.numeroParcelas = 1;
        }
    }

    @Override
    public boolean pagar(double valor) {

        if( parcelado && numeroParcelas >= 2) {
            double valorParcela = valor / numeroParcelas;
            System.out.printf(
                    "Pagamento no cartão%nValor Total: R$ %.2f%nParcelado em %dx de R$ %.2f%n",
                    valor, numeroParcelas, valorParcela);
        } else {
            System.out.printf("Pagamento no cartão à vista %n Valor Total R$ %.2f%n",
                    valor);
        }

        return true;
    }
}

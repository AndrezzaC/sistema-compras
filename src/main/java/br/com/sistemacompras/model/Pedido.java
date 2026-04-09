package br.com.sistemacompras.model;

import java.util.List;

public class Pedido {

    private List<ItemCarrinho> itens;
    private double total;

    public Pedido(List<ItemCarrinho> itens, double total) {
        this.itens = itens;
        this.total = total;
    }

    public void exibirResumo() {
        System.out.println("\n\nResumo do pedido:");

        for (ItemCarrinho item : itens) {
            Produto p = item.getProduto();

            System.out.println(
                    p.getNome() +
                            " x" + item.getQuantidade() +
                            " - R$ " + p.getPreco()
            );
        }

        System.out.printf("\nTotal: R$ %.2f%n", total);
    }
    }

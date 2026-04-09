package br.com.sistemacompras.app;

import br.com.sistemacompras.pagamento.Cartao;
import br.com.sistemacompras.pagamento.Pagamento;
import br.com.sistemacompras.pagamento.Pix;
import br.com.sistemacompras.model.Produto;
import br.com.sistemacompras.model.Carrinho;
import java.util.List;
import java.util.ArrayList;

import java.util.Scanner;

public class Main {
    public Main() {
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        Carrinho carrinho = new Carrinho();

        List<Produto> produtosDisponiveis = new ArrayList<>();

        produtosDisponiveis.add(new Produto("Mouse Scorpion", 47593, 237.87, 10));
        produtosDisponiveis.add(new Produto("Teclado Redragon", 256748, 568.99, 7));
        produtosDisponiveis.add(new Produto("Readset Redragon", 23565, 378.97, 21));
        produtosDisponiveis.add(new Produto("Monitor Samsung", 69472, 749.21, 50));
        produtosDisponiveis.add(new Produto("Tablet Samsung", 28467, 1999.99, 15));

        System.out.println("Produtos Disponíveis: ");

        for (Produto produto : produtosDisponiveis) {
            System.out.println(
                    produto.getCodigo() + " - " +
                            produto.getNome() + " | R$ " +
                            produto.getPreco() + " | Estoque: " +
                            produto.getQuantidadeEstoque()
            );
        }

        while(true) {

            System.out.println("\nEscolha uma opção:");
            System.out.println("1 - Adicionar produto");
            System.out.println("2 - Remover produto");
            System.out.println("0 - Finalizar");

            int opcaoMenu;

            while(true){
                System.out.println("Digite uma opção: ");

                if (sc.hasNextInt()) {
                    opcaoMenu = sc.nextInt();
                    break;
                } else {
                    System.out.println("Entrada inválida. Digite um número.");
                    sc.next(); //<limpa o erro!
                }
            }

            if(opcaoMenu == 0){
                break;
            }

            if (opcaoMenu == 1){
                System.out.print("\nDigite o código do produto: ");
                int codigoEscolhido = sc.nextInt();

                Produto produtoSelecionado = null;

                for(Produto produto : produtosDisponiveis){
                    if(produto.getCodigo() == codigoEscolhido){
                        produtoSelecionado = produto;
                        System.out.println("Produto selecionado: " + produtoSelecionado);
                        break;
                    }
                }

                if (produtoSelecionado == null) {
                    System.out.println("\nProduto não encontrado.");
                    continue;
                }

                System.out.print("\nDigite a quantidade: ");
                int quantidade = sc.nextInt();

                carrinho.adicionarProduto(produtoSelecionado, quantidade);
            }

            else if (opcaoMenu == 2){

                System.out.print("Digite o código do produto: \n");
                int codigo = sc.nextInt();

                System.out.print("\nDigite a quantidade que será removida: ");
                int quantidade = sc.nextInt();

                carrinho.removerProduto(codigo, quantidade);
            }

            else {
                System.out.println("Opção inválida");
            }

            System.out.println("\nCarrinho atual: ");
            carrinho.listarProdutos();
        }

        System.out.println("\nProdutos no carrinho: ");
        carrinho.listarProdutos();

        double total = carrinho.calcularTotal();
        System.out.printf("\nTotal da compra: R$ %.2f%n", total);

        System.out.println("\nEscolha o tipo de pagamento: ");
        System.out.println("1 - Pix");
        System.out.println("2 - Cartao");

        int opcao = sc.nextInt();

        Pagamento pagamento;

        if(opcao == 1){
            pagamento = new Pix();
        }
        else if (opcao == 2){

            boolean parcelado;

            while (true) {
                System.out.println("Pagamento parcelado? (s/n)");
                String resposta = sc.next();

                if (resposta.equalsIgnoreCase("s")) {
                    parcelado = true;
                    break;
                } else if (resposta.equalsIgnoreCase("n")) {
                    parcelado = false;
                    break;
                } else {
                    System.out.println("Entrada inválida. Digite 's' ou 'n'.");
                }
            }

            int parcelas = 1;

            if (parcelado){
                System.out.println("Digite o número de parcelas (2 a 6): ");
                parcelas = sc.nextInt();
            }

            pagamento = new Cartao(parcelado, parcelas);
        } else {
            System.out.println("Opção inválida.");
            return;
        }


        carrinho.finalizarCompra(pagamento);

        sc.close();
    }
}

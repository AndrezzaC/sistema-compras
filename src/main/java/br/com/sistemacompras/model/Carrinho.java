package br.com.sistemacompras.model;

import br.com.sistemacompras.pagamento.Pagamento;

import java.util.List;
import java.util.ArrayList;

public class Carrinho {

    private List<ItemCarrinho> itens;

    public Carrinho(){
        this.itens = new ArrayList<>();
    }

    public void adicionarProduto(Produto produto, int quantidade){

        if(quantidade <= 0){
            System.out.println("Quantidade inválida.");
            return;
        }

        if (produto.getQuantidadeEstoque() < quantidade){
            System.out.println("Estoque insuficiente");
            return;
        }

        for (ItemCarrinho item : itens) {
            if (item.getProduto().getCodigo() == produto.getCodigo()){

                item.adicionarQuantidade(quantidade);

                produto.setQuantidadeEstoque(
                        produto.getQuantidadeEstoque() - quantidade
                );

                return;
            }
        }

        itens.add(new ItemCarrinho(produto, quantidade));

        produto.setQuantidadeEstoque(
                produto.getQuantidadeEstoque() - quantidade
        );

        System.out.println("Produto " + produto + " adicionado ao carrinho!");
    }

    public void listarProdutos(){

        for(ItemCarrinho item : itens){
            Produto p = item.getProduto();

            System.out.println(
                    p.getNome() +
                            " x" + item.getQuantidade() +
                            String.format("R$ %.2f", p.getPreco())
                    );
        }
    }

    public double calcularTotal() {

        double total = 0;

        for (ItemCarrinho item : itens){
            total += item.getProduto().getPreco() * item.getQuantidade();
        }

        return total;
    }

    public void removerProduto(int codigo, int quantidade){

        for (ItemCarrinho item : itens){

            if (item.getProduto().getCodigo() == codigo) {
                if (item.getQuantidade() > quantidade){
                    item.removerQuantidade(quantidade);
                } else {
                    itens.remove(item);
                    return;
                }
                System.out.println("Produto removido do carrinho.");
                return;
            }
        }

        System.out.println("Produto não encontrado no carrinho");
    }

    public void finalizarCompra(Pagamento pagamento){
        double total = calcularTotal();
        pagamento.pagar(total);
        System.out.println("\nCompra finalizada!\n");

        Pedido pedido = new Pedido(itens, total);
        pedido.exibirResumo();
    }

}

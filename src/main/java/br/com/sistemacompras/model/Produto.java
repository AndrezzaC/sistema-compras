package br.com.sistemacompras.model;

public class Produto extends Item{

    private int quantidadeEstoque;

    public Produto(String nome, int codigo, double preco, int quantidadeEstoque) {
        super(nome, codigo, preco);
        this.quantidadeEstoque = quantidadeEstoque;
    }

    public int getQuantidadeEstoque() {
        return quantidadeEstoque;
    }

    public void setQuantidadeEstoque(int quantidadeEstoque) {
        this.quantidadeEstoque = quantidadeEstoque;
    }

    @Override
    public String toString(){
        return String.format("%s - R$ %.2f", getNome(), getPreco());
    }
}

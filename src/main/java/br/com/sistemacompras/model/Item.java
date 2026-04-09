package br.com.sistemacompras.model;

public class Item {

    private String nome;
    private int codigo;
    private double preco;

    public Item(String nome, int codigo, double preco) {
        this.nome = nome;
        this.codigo = codigo;
        this.preco = preco;
    }

    public String getNome() {
        return nome;
    }

    public int getCodigo() {
        return codigo;
    }

    public double getPreco() {
        return preco;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void atualizarPreco(double novoPreco){
        if (novoPreco > 0){
            this.preco = novoPreco;
        }
    }
}

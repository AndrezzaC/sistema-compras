package br.com.sistemacompras.model;

import java.util.List;
import java.util.ArrayList;

public class Carrinho {

    private List<Produto> produtos;

    public Carrinho(){
        this.produtos = new ArrayList<>();
    }

    public void adicionarProduto(Produto produto){
        produtos.add(produto);
    }

    public void listarProdutos(){
        for(Produto produto : produtos){
            System.out.println(produto.getNome());
        }
    }


}

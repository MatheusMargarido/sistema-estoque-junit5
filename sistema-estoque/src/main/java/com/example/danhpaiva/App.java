package com.example.danhpaiva;

public class App {
    public static void main(String[] args) {
        SistemaEstoque sistemaEstoque = new SistemaEstoque();

        sistemaEstoque.adicionarProduto("Iphone 16e", 5);
        System.out.println(sistemaEstoque.obterHistoricoTransacoes());
    }
}

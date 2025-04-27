package com.example.danhpaiva;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SistemaEstoque {
  private Map<String, Integer> estoque;
  private List<String> historicoTransacoes;

  public SistemaEstoque() {
    this.estoque = new HashMap<>();
    this.historicoTransacoes = new ArrayList<>();
  }

  public void adicionarProduto(String nomeProduto, int quantidade) {
    if (nomeProduto == null || nomeProduto.trim().isEmpty()) {
      throw new IllegalArgumentException("Nome do produto não pode ser nulo ou vazio.");
    }
    if (quantidade <= 0) {
      throw new IllegalArgumentException("A quantidade deve ser maior que zero.");
    }

    estoque.put(nomeProduto, estoque.getOrDefault(nomeProduto, 0) + quantidade);
    historicoTransacoes.add("Adicionado " + quantidade + " unidade(s) de " + nomeProduto);
  }

  public void removerProduto(String nomeProduto, int quantidade) {
    if (nomeProduto == null || nomeProduto.trim().isEmpty()) {
      throw new IllegalArgumentException("Nome do produto não pode ser nulo ou vazio.");
    }
    if (quantidade <= 0) {
      throw new IllegalArgumentException("A quantidade deve ser maior que zero.");
    }
    if (!estoque.containsKey(nomeProduto) || estoque.get(nomeProduto) < quantidade) {
      throw new IllegalArgumentException(
          "Estoque insuficiente para remover " + quantidade + " unidade(s) de " + nomeProduto + ".");
    }

    estoque.put(nomeProduto, estoque.get(nomeProduto) - quantidade);
    historicoTransacoes.add("Removido " + quantidade + " unidade(s) de " + nomeProduto);
    if (estoque.get(nomeProduto) == 0) {
      estoque.remove(nomeProduto);
    }
  }

  public int consultarEstoque(String nomeProduto) {
    if (nomeProduto == null || nomeProduto.trim().isEmpty()) {
      throw new IllegalArgumentException("Nome do produto não pode ser nulo ou vazio.");
    }
    return estoque.getOrDefault(nomeProduto, 0);
  }

  public List<String> obterHistoricoTransacoes() {
    return new ArrayList<>(historicoTransacoes);
  }

  public boolean verificarDisponibilidade(String nomeProduto, int quantidadeNecessaria) {
    if (nomeProduto == null || nomeProduto.trim().isEmpty()) {
      throw new IllegalArgumentException("Nome do produto não pode ser nulo ou vazio.");
    }
    if (quantidadeNecessaria <= 0) {
      throw new IllegalArgumentException("A quantidade necessária deve ser maior que zero.");
    }
    return estoque.containsKey(nomeProduto) && estoque.get(nomeProduto) >= quantidadeNecessaria;
  }
}

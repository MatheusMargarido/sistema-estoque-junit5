package com.example.danhpaiva;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

public class SistemaEstoqueTest {
  public SistemaEstoque sistemaEstoque;
  
  @Before
  public void setUp() {
    sistemaEstoque = new SistemaEstoque();
  }

  @Test
  public void testeAdicionarProduto_ConsultaEstoque_Transacoes() {
    sistemaEstoque.adicionarProduto("Mouse", 5);
    sistemaEstoque.adicionarProduto("Mouse", 5);
    assertEquals(10, sistemaEstoque.consultarEstoque("Mouse"));
    assertEquals(2, sistemaEstoque.obterHistoricoTransacoes().size());
    assertEquals("Adicionado 5 unidade(s) de Mouse", sistemaEstoque.obterHistoricoTransacoes().get(0));
  }

  @Test
  public void testeRemoverProduto() {
    sistemaEstoque.adicionarProduto("Mouse", 5);
    sistemaEstoque.removerProduto("Mouse", 1);
    assertEquals(4, sistemaEstoque.consultarEstoque("Mouse"));
  }

  @Test
  public void testarRemocaoSemProdutoEmEstoque() {
    assertThrows(IllegalArgumentException.class, () -> sistemaEstoque.removerProduto("Mouse", 12));
    assertEquals(0, sistemaEstoque.obterHistoricoTransacoes().size());
  }

  @Test
  public void adicionarProdutoComNomeNuloOuVazio() {
    assertThrows(IllegalArgumentException.class, () -> sistemaEstoque.adicionarProduto(null, 3));
    assertThrows(IllegalArgumentException.class, () -> sistemaEstoque.adicionarProduto(" ", 3));
    assertEquals(0, sistemaEstoque.obterHistoricoTransacoes().size());
  }

  @Test
  public void adicionarQuantidadeNegativa() {
    assertThrows(IllegalArgumentException.class, () -> sistemaEstoque.adicionarProduto("Caderno", -3));
    assertEquals(0, sistemaEstoque.obterHistoricoTransacoes().size());
  }

  @Test
  public void removerProdutoComNomeNuloOuVazio() {
    assertThrows(IllegalArgumentException.class, () -> sistemaEstoque.removerProduto(null, 4));
    assertThrows(IllegalArgumentException.class, () -> sistemaEstoque.removerProduto(" ", 4));
    assertEquals(0, sistemaEstoque.obterHistoricoTransacoes().size());
  }

  @Test
  public void removerQuantidadeNegativa() {
    assertThrows(IllegalArgumentException.class, () -> sistemaEstoque.removerProduto("Caderno", -3));
    assertEquals(0, sistemaEstoque.obterHistoricoTransacoes().size());
  }

  @Test
  public void removerQuantidadeParaZeroRetiraOProduto() {
    sistemaEstoque.adicionarProduto("Mouse", 5);
    sistemaEstoque.removerProduto("Mouse", 5);
    assertEquals(0, sistemaEstoque.consultarEstoque("Mouse"));
  }

  @Test
  public void consultarProdutoComNomeNuloOuVazio() {
    assertThrows(IllegalArgumentException.class, () -> sistemaEstoque.consultarEstoque(null));
    assertThrows(IllegalArgumentException.class, () -> sistemaEstoque.consultarEstoque(" "));
    assertEquals(0, sistemaEstoque.obterHistoricoTransacoes().size());
  }

  @Test
  public void veririficarProdutoComQuantidadeNegativaOuNenhuma() {
    assertThrows(IllegalArgumentException.class, () -> sistemaEstoque.verificarDisponibilidade("Fone", -5));
    assertThrows(IllegalArgumentException.class, () -> sistemaEstoque.verificarDisponibilidade("Fone", 0));
  }

  @Test
  public void testeVerificarDispolibilidade() {
    sistemaEstoque.adicionarProduto("Garrafa", 6);
    assertTrue(sistemaEstoque.verificarDisponibilidade("Garrafa", 2));
    assertEquals(1, sistemaEstoque.obterHistoricoTransacoes().size());
  }

  @Test
  public void verirficarDisponibilidadeComNomeNuloOuVazio() {
    assertThrows(IllegalArgumentException.class, () -> sistemaEstoque.verificarDisponibilidade(null, 2));
    assertThrows(IllegalArgumentException.class, () -> sistemaEstoque.verificarDisponibilidade(" ", 2));
  }

  @Test
  public void verificarQuantidadeInsuficiente() {
    sistemaEstoque.adicionarProduto("Garrafa", 1);
    assertFalse(sistemaEstoque.verificarDisponibilidade("Garrafa", 2));
    assertEquals(1, sistemaEstoque.obterHistoricoTransacoes().size());
  }
}

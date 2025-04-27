# Sistema de Estoque
Exemplo para avaliarmos a cobertura de testes de 0% a +70%

Explicação do Código:

- SistemaEstoque Class:<br>
  Representa o sistema de controle de estoque.

- estoque (Map): <br>
  Utiliza um HashMap para armazenar os produtos e suas respectivas quantidades em estoque. <br>
  A chave é o nome do produto (String) e o valor é a quantidade (Integer).
  
- historicoTransacoes (List):<br>
  Uma ArrayList para registrar as operações de adição e remoção de produtos, facilitando o rastreamento das movimentações.

- adicionarProduto(String nomeProduto, int quantidade):<br>
  Adiciona uma determinada quantidade de um produto ao estoque.<br>
  Se o produto já existir, incrementa a quantidade.<br>
  Registra a transação no histórico.<br>
  Lança uma IllegalArgumentException se o nome do produto for nulo ou vazio, ou se a quantidade for menor ou igual a zero.

- removerProduto(String nomeProduto, int quantidade):<br>
  Remove uma determinada quantidade de um produto do estoque.<br>
  Verifica se o produto existe e se há estoque suficiente.<br>
  Registra a transação no histórico.<br>
  Remove o produto do estoque se a quantidade após a remoção for zero.<br>
  Lança uma IllegalArgumentException se o nome do produto for nulo ou vazio, se a quantidade for menor ou igual a zero, ou se não houver estoque suficiente.

- consultarEstoque(String nomeProduto):<br>
  Retorna a quantidade atual em estoque de um determinado produto.<br>
  Retorna 0 se o produto não estiver cadastrado.<br>
  Lança uma IllegalArgumentException se o nome do produto for nulo ou vazio.<br>

- obterHistoricoTransacoes():<br>
  Retorna uma cópia da lista de histórico de transações.<br>
  verificarDisponibilidade(String nomeProduto, int quantidadeNecessaria):<br>
  Verifica se há quantidade suficiente de um determinado produto em estoque para atender a uma necessidade.<br>
  Lança uma IllegalArgumentException se o nome do produto for nulo ou vazio, ou se a quantidade necessária for menor ou igual a zero.<br>
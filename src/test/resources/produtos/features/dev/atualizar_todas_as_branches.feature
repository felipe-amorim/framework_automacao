Feature: Atualizar todas as branches

  @AtualizarBranches
  Scenario: Atualizar todas as branches, Author: Felipe Amorim, Category: Atualizacao-Branches, Environment: CMD
    Given O usuario esta na brach "felipe_dev"
    And O usuario atualiza a branch local "oji"
    And O usuario atualiza a branch local "hanb"
    And O usuario atualiza a branch local "spacely"
    And O usuario atualiza a branch local "ongoing"
    And O usuario atualiza a branch local "calculadora_spread"
    And O usuario atualiza a branch local "marabu"
    And O usuario atualiza a branch local "netsms"
    And O usuario atualiza a branch local "netsales"
    When O usuario faz merge com a branch "oji"
    When O usuario faz merge com a branch "hanb"
    And O usuario faz merge com a branch "spacely"
    And O usuario faz merge com a branch "ongoing"
    And O usuario faz merge com a branch "calculadora_spread"
    And O usuario faz merge com a branch "marabu"
    And O usuario faz merge com a branch "netsms"
    And O usuario faz merge com a branch "netsales"
    Then O usuario atualiza a branch remota corrente
    And O usuario atualiza a branch remota master
    And O usuario atualiza a branch remota "oji"
    And O usuario atualiza a branch remota "hanb"
    And O usuario atualiza a branch remota "spacely"
    And O usuario atualiza a branch remota "ongoing"
    And O usuario atualiza a branch remota "calculadora_spread"
    And O usuario atualiza a branch remota "marabu"
    And O usuario atualiza a branch remota "netsms"
    And O usuario atualiza a branch remota "netsales"
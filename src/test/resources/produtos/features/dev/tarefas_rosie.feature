Feature: Inclusão de tarefas rosie

  @AdicionarTasks
  Scenario: CT01 Inclusão de tarefas rosie , Author: Felipe Amorim, Category: Rosie-tarefas, Environment: Chrome
    Given O usuario esta na pagina "https://rosie.artit.com.br/auth/login"
    And O usuario realiza o login
    And O usuario acessa a aba tarefas
    And O usuario acessa o quadro de tarefas do projeto Oji
    And O usuario le o arquivo excel com todos os casos de teste e cria tarefas no quadro

  @LerTasks
  Scenario: CT02 Inclusão de tarefas rosie , Author: Felipe Amorim, Category: Rosie-tarefas, Environment: Chrome
    Given O usuario esta na pagina "https://rosie.artit.com.br/auth/login"
    And O usuario realiza o login
    And O usuario acessa a aba tarefas
    And O usuario acessa o quadro de tarefas do projeto Marabu
    And O usuario le todas as tarefas do marabu

  @Mongo
  Scenario: CT011 scenario1 , Author: Felipe Amorim, Category: Rosie-tarefas, Environment: Chrome
    Given O usuario esta na pagina "https://rosie.artit.com.br/auth/login"
    And O usuario realiza o login

  @Mongo
  Scenario: CT012 scenario2 , Author: Felipe Amorim, Category: Rosie-tarefas, Environment: Chrome
    Given O usuario esta na pagina "https://rosie.artit.com.br/auth/login"
    And O usuario realiza o login


  @AdicionarIssues
  Scenario: CT03 Inclusão de tarefas rosie quadro de issues, Author: Felipe Amorim, Category: Rosie-tarefas, Environment: Chrome
    Given O usuario esta na pagina "https://rosie.artit.com.br/auth/login"
    And O usuario realiza o login
    And O usuario acessa a aba tarefas
    And O usuario acessa o quadro de tarefas de issues
    And O usuario insere todos os issues pendentes

  @TestePostGres
  Scenario: CT04 Teste de banco postgres , Author: Felipe Amorim, Category: Rosie-tarefas, Environment: Chrome
    Given O usuario esta na pagina "https://rosie.artit.com.br/auth/login"
    And O usuario testa o banco postgres


  @AdicionarTasksMarabu
  Scenario: CT01 Inclusão de tarefas rosie , Author: Denis Castro, Category: Rosie-tarefas, Environment: Chrome
    Given O usuario esta na pagina "https://rosie.artit.com.br/auth/login"
    And O usuario realiza o login
    And O usuario acessa a aba tarefas
    And O usuario acessa o quadro de tarefas do projeto Marabu
    And O usuario le o arquivo excel com todos os casos de teste e cria tarefas no quadro
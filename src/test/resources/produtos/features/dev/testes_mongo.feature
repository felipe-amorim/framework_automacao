Feature: Testes do mongo

  @Mongo
  Scenario: CT013 scenario1 , Author: Felipe Amorim, Category: Rosie-tarefas, Environment: Chrome
    Given O usuario esta na pagina "https://rosie.artit.com.br/auth/login"
    And O usuario realiza o login

  @Mongo
  Scenario: CT014 scenario2 , Author: Felipe Amorim, Category: Rosie-tarefas, Environment: Chrome
    Given O usuario esta na pagina "https://rosie.artit.com.br/auth/login"
    And O usuario realiza o login

#Feature: fluxo abertura os

  @FluxoAberturaOS @Denis
  Scenario: FluxoAberturaOS, Author: Denis Castro, Category:, Environment: Chrome
    Given O navegador esta na Tela Login
    And O usuario entra com usuario "cautomacao1@marabu.com" e senha "@Teste123"
    And A tela inicial marabu e exibida
    And O usuario clica em Cadastro
    And O usuario navega para aba equipamentos
    And O usuario clica em novo para cadastro de equipamentos
    And O usuario preenche o combobox fabricante para cadastro de equipamento com "HP"
    And O usuario preenche o combobox modelo da impressora para cadastro de equipamento com "Equipamento"
    And O usuario preenche o campo numero de serie para cadastro de equipamento
    And O usuario preenche o combobox sistema de abastecimento para cadastro de equipamento com "Cartucho"
    And O usuario preenche o combobox cabeca de impressao para cadastro de equipamento com "Samsung"
    And O usuario preenche o combobox quantidade de cabecas de impressao para cadastro de equipamento com "4"
    And O usuario preenhe o combobox set de tintas para cadastro de equipamento com "CMYK"
    And O usuario clica em salvar para finalizar cadastro de equipamentos
    And O usuario altera o fluxo principal para o teste prosseguir warning
    And O usuario valida que a busca retornou o equipamento cadastrado no ct

    And O usuario clica em abrir os para equipamento cadastrado
    And O usuario preenche o campo tipo para abrir os com ""
    And O usuario preenche o campo situacao do equipamento para abrir os com ""
    And O usuario preenche o campo data de agendamento para abrir os
    And O usuario marca o check box de aceitar proposta de prestacao de servico para abrir os
    And O usuario clica em abrir para abrir os
    And O usuario valida que a os foi aberta

    And O usuario clica em logout

    And O navegador esta na Tela Login
    And O usuario entra com usuario "udautomacao1@marabu.com" e senha "@Teste123"
    And A tela inicial marabu e exibida

    And O usuario clica no menu processos
    And O usuario navega para a tela de agendamento
    And O usuario clica no botao agendamento da os do ct

    And O usuario associa um tecnico a os
    And O usuario clica em agendar na tela de agendamento de os
    And O usuario valida que o status da os e ""

    And O usuario clica em logout

    And O navegador esta na Tela Login
    And O usuario entra com usuario "tautomacao1@marabu.com" e senha "@Teste123"
    And A tela inicial marabu e exibida

    And O usuario clica no menu processos
    And O usuario navega para a tela de ordem de servico
################
    And O usuario clica no botao relatorio de conversao da os

    And O usuario preenche o campo operador da tela de relatorio de conversao com ""
    And O usuario preenche o campo participante da tela de relatorio de conversao com ""

    And O usuario acessa o form de local de impressao da tela de relatorio de conversao
    And O usuario preenche o campo tipo para o form substrato do cliente com ""
    And O usuario clica no botao adicionar para tipo de substrato do cliente

    And O usuario acessa o form de tinta e auxiliares da tela de relatorio de conversao
    And O usuario preenche o combobox tinta para o form de tintas utilizadas na conversao na tela de relatorio de conversao com ""
    And O usuario preenche o campo lote para o form de tintas utilizadas na conversao na tela de relatorio de conversao com ""
    And O usuario clica no botao adicionar para o form tintas utilizadas

    And O usuario preenche o combobox material para o form de materiais auxiliares com ""
    And O usuario preenche o campo lote para o form de materiais auxiliares com ""
    And O usuario clica no botao adicionar para o form materiais auxiliares

    And O usuario acessa o form garantia e aprovacao da tela de relatorio de conversao
    And O usuario preenche o campo cidade do form vistoria tecnica na tela de relatorio de conversao com ""
    And O usuario preenche o campo data da assinatura para o form de visita tecnica na tela de relatorio de conversao
    And O usuario preenche o campo assinado por para o form de visita tecnica na tela de relatorio de conversao com ""

    And O usuario acessa o form imagens da tela de relatorio de conversao
    And O usuario preenche o campo descricao do form de imagem da conversao na tela de relatorio de conversao com ""
    And O usuario associa uma imagem ao campo imagem do form de imagens da conversao na tela de relatorio de conversao
    And O usuario clica no botao adicionar para o form imagens da conversao

    And O usuario clica em finalizar para finalizar o relatorio de conversao
    And O usuario confirma a pergunta de deseja finalizar o relatorio de conversao

    And O usuario clica no botao tarefas da os

    And O usuario abre o form dados da os da tarefa
    And O usuario valida que o numero da os esta correto
    And O usuario valida que o tecnico associado a os esta correto
    And O usuario valida que o numero de serie do equipamento esta correto
package produtos.dev.stepdefs;

import cucumber.api.java.en.Given;
import support.CoreScreen;

import static produtos.dev.objetos.DesenvolvimentoSikuli.*;

public class StepDefsDesenvolvimento extends CoreScreen {

    @Given("O usuario esta testando a execucao do sikuli em mais de uma tela")
    public void oUsuarioEstaTestandoAExecucaoDoSikuliEmMaisDeUmaTela() {

    }

    @Given("O usuario esta testando a execucao do sikuli")
    public void oUsuarioEstaTestandoAExecucaoDoSikuli() {
        String a = "D:\\Projetos\\Java\\fabrica_de_testes_automacao\\src\\test\\resources\\tt.png";
        String a2 = "D:\\Projetos\\Java\\fabrica_de_testes_automacao\\src\\test\\resources\\tt2.png";
        String a3 = "D:\\Projetos\\Java\\fabrica_de_testes_automacao\\src\\test\\resources\\tt3.png";
        log().setLocator(desenvolvimentoSikuli);
        //find(a).click();
        find(img2).click().twice();
        find(img3).click().thrice();
        send().text("teste de digitacao");
        send().slow().text("teste de digitscao devagar");
    }
}

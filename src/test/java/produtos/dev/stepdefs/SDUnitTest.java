package produtos.dev.stepdefs;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import support.CoreWeb;

import static produtos.dev.objetos.UnitTest.*;

public class SDUnitTest extends CoreWeb {
    @Given("O usuario esta na pagina {string}")
    public void oUsuarioEstaNaPagina(String arg0) {
        webDriver().navigate(arg0);
    }


    @And("O usuario testa o clique")
    public void oUsuarioTestaOClique() {
        log().setLocator(unitTest);
        find(unitTestSearchButton).click();
    }

    @And("O usuario testa o enviar")
    public void oUsuarioTestaOEnviar() {
        log().setLocator(unitTest);
        find(unitTestSearchInput).send().text("teste");
    }
}

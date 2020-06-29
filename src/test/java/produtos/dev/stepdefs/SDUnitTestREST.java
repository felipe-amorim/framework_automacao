package produtos.dev.stepdefs;

import cucumber.api.java.en.Given;
import org.json.JSONObject;
import support.CoreREST;

public class SDUnitTestREST extends CoreREST {
    @Given("O usuario testa o request")
    public void oUsuarioEstaNaPagina() {
        createRequest("http://gitlabhomolog.artit.com.br/api/v4/").endpoint("projects").get();
        parameters().put("search", "automacao");
        headers().put("PRIVATE-TOKEN", "ixtjiYQY4ffSc-Wg1Xz6");
        //headers().putToken("");
        //body().put(new JSONObject(""));
        send();


        response().status().mustBe(200);
        response().body().mustHave("id");
        response().responseTime().mustBeLessThan(5000);

    }

    @Given("O usuario testa o request post")
    public void oUsuarioEstaNaPagina2() {
        createRequest("http://gitlabhomolog.artit.com.br/api/v4/").endpoint("projects/136/repository/branches").post();
        parameters().put("search", "automacao");
        headers().put("PRIVATE-TOKEN", "ixtjiYQY4ffSc-Wg1Xz6");
        //headers().putToken("");
        JSONObject json = new JSONObject();
        json.put("id", "136");
        json.put("branch", "aa315");
        json.put("ref", "automacao");
        body().put(json);
        send();


        response().status().mustBe(201);
        response().body().mustHave("id");
        response().responseTime().mustBeLessThan(5000);

    }
}

package produtos.dev.runner;


import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/java/produtos/dev/features/",
        glue={"produtos.dev.stepdefs"},
        plugin = { "intern.ListCucumber" },
        tags = {"@AtualizarBranches"}
)

public class Run {
}

package produtos.dev.runner;


import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/",
        glue={"produtos"},
        plugin = { "intern.plugin.ListCucumber" }
)

public class Run {
}

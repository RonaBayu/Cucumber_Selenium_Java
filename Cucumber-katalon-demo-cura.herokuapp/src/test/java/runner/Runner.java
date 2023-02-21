package runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        tags = "",
        features="src/test/resources/features",
        glue={"stepDefinition", "runner"},
        plugin = {"pretty","html:target/report/cucumber-report.html","json:target/report/cucumber-report.json,"}
)

public class Runner {

}
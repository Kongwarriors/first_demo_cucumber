package Runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.DataProvider;

@CucumberOptions (
        features = "src/test/resources/features",
        glue = {""},
        plugin = {"pretty", "html:target/cucumber-html-report.html"}
)


public class RunnerTest extends AbstractTestNGCucumberTests {
    @DataProvider
    @Override
    public Object[][] scenarios(){
        return super.scenarios();
    }
}

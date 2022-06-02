package Runner;

import Tests.TestBase;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = "src/test/java/Features",glue = {"Steps"}
        ,plugin = {"pretty","html:target/cucumber-html-report.html"})
public class TestRunner extends TestBase {


}

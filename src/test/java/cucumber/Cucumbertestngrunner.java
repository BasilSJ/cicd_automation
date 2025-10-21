package cucumber;

import io.cucumber.testng.AbstractTestNGCucumberTests;



import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features="src/test/java/cucumber",glue="cucumberStepdefinition",
monochrome=true,tags="@submit",plugin= {"html:target/cucumber.html","json:target/cucumber.json"}
)
public class Cucumbertestngrunner extends AbstractTestNGCucumberTests {

}

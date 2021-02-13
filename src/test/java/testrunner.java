
import org.junit.runner.RunWith;
import org.testng.annotations.Test;


import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import cucumber.api.testng.AbstractTestNGCucumberTests;
@RunWith(Cucumber.class)
@CucumberOptions(
        features={"Features"},
        glue={"testcases"}
        
)
@Test
public class testrunner extends AbstractTestNGCucumberTests {
    
}
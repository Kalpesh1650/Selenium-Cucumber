package runner;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import cucumber.api.testng.AbstractTestNGCucumberTests;

///---Junit Test Runner--////
/*@RunWith(Cucumber.class)
@CucumberOptions(features="features",glue={"stepDefination"}) 
public class TestRunner {

	
	
}
*/

///---TestNG Test Runner--////
@CucumberOptions(features="features",
				 glue={"stepDefination"},
				 plugin={"html:target/cucumber-html-report"}) 
public class TestRunner extends AbstractTestNGCucumberTests {
	
}


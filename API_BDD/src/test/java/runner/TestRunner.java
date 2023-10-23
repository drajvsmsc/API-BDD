package runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;


@CucumberOptions(features= {"src/test/resources/features/createorder.feature"},plugin ={"html:target/cucumber-reports/cucumber-html-report.html"
        ,"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"} ,glue="Stepdefinitions")
public class TestRunner extends AbstractTestNGCucumberTests {
}
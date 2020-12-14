package ru.test.cucumber;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions( glue = "ru.test.cucumber", features = "src/test/resources/ru/test/cucumber/features")
public class CucumberTestRunner {
}

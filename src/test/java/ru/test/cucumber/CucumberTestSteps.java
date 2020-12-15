package ru.test.cucumber;


import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import ru.test.Calculator;

import static junit.framework.TestCase.assertEquals;

public class CucumberTestSteps {

    double result;

    @When("^выполнить операцию ([\\u002d\\u002b\\u002a\\u002f]?) с числами (-?\\d*\\.?\\d+) и (-?\\d*\\.?\\d+)$")
    public void operation (char operation, String value1, String value2) {
        double result = Calculator.calculator(Double.parseDouble(value1), Double.parseDouble(value2), operation);
        this.result = result;
    }

    @Then("^результат выполнения операции равен (-?\\d*\\.?\\d+)$")
    public void resultCompare(String resultExpected) {

        assertEquals(Double.parseDouble(resultExpected), result);

    }
}

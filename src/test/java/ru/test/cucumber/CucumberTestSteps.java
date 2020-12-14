package ru.test.cucumber;


import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import ru.test.Calculator;

import static junit.framework.TestCase.assertEquals;

public class CucumberTestSteps {
    @When("^выполнить операцию ([\\u002d\\u002b\\u002a\\u002f]?) с числами (-?\\d*\\.?\\d+) и (-?\\d*\\.?\\d+)$")
    public double operation (double value1, double value2, char operation) {
        double result = Calculator.calculator(value1, value2, operation);
        System.out.println(result);
        return result;
    }

    @Then("^результат выполнения операции равен (-?\\d*\\.?\\d+)$")
    public void resultCompare(double result, double resultExpected) {

        assertEquals(resultExpected, result);

    }
}

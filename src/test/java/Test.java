import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static junit.framework.TestCase.assertEquals;

@RunWith(Parameterized.class)
class ParameterizeTest {
    private String operand1;
    private String operand2;
    private String sign;
    private String resultExpected;

    public ParameterizeTest(String operand1, String operand2, String sign, String resultExpected) {
        this.operand1 = operand1;
        this.operand2 = operand2;
        this.sign = sign;
        this.resultExpected = resultExpected;
    }

    @Parameterized.Parameters(name = "{index}:operation({0}+{1})={3}")
    public static List<String[]> dataForTest() throws IOException {
        Reader reader = new Reader();
        ArrayList<String[]> fromCSV;
        fromCSV = reader.reader(new File("C:\\Users\\Lias_\\IdeaProjects\\TestLearning\\files\\Hello.csv"));
        return fromCSV;

    }

    public void testMain(String operand1, String operand2, String sign, String resultExpected) throws IOException {
        Matcher matcher = new Matcher();
        Calculator calculator = new Calculator();
        if ((matcher.matchingNumber(operand1) && matcher.matchingNumber(operand2) && matcher.matchingSign(sign) && matcher.matchingNumber(resultExpected))) {
            double result;
            double number1 = Double.parseDouble(operand1);
            double number2 = Double.parseDouble(operand2);
            char mathSign = sign.charAt(0);

            result = calculator.calculator(number1, number2, mathSign);

            assertEquals(Double.parseDouble(resultExpected), result);
        } else {
            System.out.println("EROOOOR");
        }

    }
}


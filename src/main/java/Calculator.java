public class Calculator {

    public static double calculator(double operand1, double operand2, char sign) {

        switch (sign) {

            case '+' -> {
                return operand1 + operand2;
            }
            case '-' -> {
                return operand1 - operand2;
            }
            case '*' -> {
                return operand1 * operand2;
            }
            case '/' -> {
                return operand1 / operand2;
            }
        }
        return 0;
    }
}

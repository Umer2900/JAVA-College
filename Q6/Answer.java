class Calculator 
{
    // Method to evaluate a mathematical expression
    public double evaluate(String expression) {
        // Remove all whitespaces from the expression
        expression = expression.replaceAll("\\s+", "");
        
        // First, handle the parentheses by evaluating inner expressions
        while (expression.contains("(")) {
            int start = expression.lastIndexOf('(');
            int end = expression.indexOf(')', start);
            String subExpression = expression.substring(start + 1, end);
            double result = evaluateSubExpression(subExpression);
            expression = expression.substring(0, start) + result + expression.substring(end + 1);
        }

        // Evaluate the final expression without parentheses
        return evaluateSubExpression(expression);
    }

    // Method to evaluate simple expressions without parentheses
    private double evaluateSubExpression(String expression) {
        double result = 0;
        char operator = '+';
        double temp = 0;

        for (int i = 0; i < expression.length(); i++) {
            char ch = expression.charAt(i);

            if (Character.isDigit(ch)) {
                temp = temp * 10 + (ch - '0');
            }

            // When we encounter an operator or the end of the expression, perform the calculation
            if (!Character.isDigit(ch) || i == expression.length() - 1) {
                if (operator == '+') {
                    result += temp;
                } else if (operator == '-') {
                    result -= temp;
                } else if (operator == '*') {
                    result *= temp;
                } else if (operator == '/') {
                    if (temp == 0) {
                        throw new ArithmeticException("Cannot divide by zero.");
                    }
                    result /= temp;
                }

                // Reset the temp variable and change the operator
                temp = 0;
                if (i < expression.length() - 1) {
                    operator = expression.charAt(i);
                }
            }
        }

        return result;
    }
}

class Main 
{
    public static void main(String[] args) 
    {
        Calculator calculator = new Calculator();

        // Test with different expressions
        String expression1 = "5 + 3 * 2";
        String expression2 = "(1 + 2) * 3";
        String expression3 = "10 + (2 * 3) - 4";

        System.out.println("Result of '" + expression1 + "': " + calculator.evaluate(expression1));
        System.out.println("Result of '" + expression2 + "': " + calculator.evaluate(expression2));
        System.out.println("Result of '" + expression3 + "': " + calculator.evaluate(expression3));
    }
}

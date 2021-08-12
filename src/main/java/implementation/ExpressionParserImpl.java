package implementation;

import api.expression.ExpressionParser;
import api.expression.ParseException;

public class ExpressionParserImpl implements ExpressionParser {

    public enum OperatorType {
        PLUS, MINUS
    }

    private Integer sum;

    private boolean operand1;
    private boolean operand2;

    private boolean operatorExists;
    private OperatorType operator;

    @Override
    public int parse(String expression) throws ParseException {

        InitializeValues();
        StringBuilder sb = new StringBuilder();

        if(expression == null)
            throw new IllegalArgumentException();

        for (int i = 0; i < expression.length(); i++) {

            var c = expression.charAt(i);

            switch (c) {
                case '-':
                    if (!operatorExists) {
                        operator = OperatorType.MINUS;
                        operatorExists = true;
                        continue;
                    } else {
                        throw new ParseException("Wrong sequence!");
                    }
                case '+':
                    if (!operatorExists) {
                        operator = OperatorType.PLUS;
                        operatorExists = true;
                        continue;
                    } else {
                        throw new ParseException("Wrong sequence!");
                    }
                default:
                    if (c <= '9' && c >= '0') {

                        sb.append(c);

                        if ((i + 1) < expression.length()) {

                            if (expression.charAt(i + 1) > '9' || expression.charAt(i + 1) < '0') {

                                AddNewNumber(sb);
                            }

                        } else {
                            AddNewNumber(sb);
                        }

                    }
            }

        }

        return sum;

    }

    private void InitializeValues() {
        sum = null;
        operand1 = false;
        operand2 = false;
        operatorExists = false;
        operator = null;
    }

    private void AddNewNumber(StringBuilder sb) throws ParseException {

        try {

            if (operatorExists && sum == null) {

                sum = 0;
                if (operator == OperatorType.MINUS) {

                    sum -= Integer.parseInt(sb.toString());
                } else {
                    sum += Integer.parseInt(sb.toString());
                }

            } else if (!operatorExists && sum == null) {

                sum = 0;
                sum += Integer.parseInt(sb.toString());

            } else if (operatorExists) {

                if (operator == OperatorType.MINUS) {
                    sum -= Integer.parseInt(sb.toString());
                } else {
                    sum += Integer.parseInt(sb.toString());
                }

            } else if (!operatorExists) {

                throw new ParseException("Wrong sequence!");
            }

            operator = null;
            operatorExists = false;
            sb.setLength(0);
        }catch(NumberFormatException arEx){
            throw new ParseException("Incorrect input data");
        }
    }

}

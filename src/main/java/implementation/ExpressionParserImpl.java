package implementation;

import api.expression.ExpressionParser;
import api.expression.ParseException;

public class ExpressionParserImpl implements ExpressionParser {

    public enum OperatorType{
        PLUS, MINUS
    }

    private Integer operand1;
    private Integer operand2;

    private Integer sum;

    private boolean operatorExists;
    private OperatorType operator;

    @Override
    public int parse(String expression) throws ParseException {
        sum = 0;
        operand1 = null;
        operand2 = null;
        operatorExists = false;
        operator = null;


        var sb = new StringBuilder();

        for (int i = 0; i< expression.length(); i++){

            var c = expression.charAt(i);

            //if there is the ed of array string and no more numbers we won't enter the cycle
            if(c == ' ') {
                sb.append(expression.charAt(i));
                sb.append(expression.charAt(i + 1));
                sb.append(expression.charAt(i + 2));
                if (sb.toString().equals(" + ")) {
                    operator = OperatorType.PLUS;
                    i += 2;
                } else if (sb.toString().equals(" - ")) {
                    operator = OperatorType.MINUS;
                    i += 2;
                } else {
                    throw new ParseException("Wrong sequence");
                }

                sb.setLength(0);
            }
            else if( (c <= '9' && c >= '0') || c =='-'){

                sb.append(c);

                if(i + 1 < expression.length()){
                    if(expression.charAt(i+1) == ' '){

                        AddNewNumber(sb);


                    }
                }
                else{

                    AddNewNumber(sb);
                }


            }else{
                throw new ParseException("Wrong sequence");
            }

        }

        return sum;
    }

    private void AddNewNumber(StringBuilder sb) {
        if(operator == null || operator == OperatorType.PLUS){
            sum += Integer.parseInt(sb.toString());

            sb.setLength(0);
            operator = null;
        } else if (operator == OperatorType.MINUS) {
//if num > maxValue
            sum -= Integer.parseInt(sb.toString());

            sb.setLength(0);
            operator = null;
        }
    }
}

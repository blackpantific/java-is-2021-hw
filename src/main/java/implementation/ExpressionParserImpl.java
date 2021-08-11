package implementation;

import api.expression.ExpressionParser;
import api.expression.ParseException;

public class ExpressionParserImpl implements ExpressionParser {

    private Integer operand1 = null;
    private Integer operand2 = null;

    private Integer sum = 0;

    private boolean operatorExists = false;
    private String operator = "";

    @Override
    public int parse(String expression) throws ParseException {

        StringBuilder sb = new StringBuilder();
        //sb.append()
        //expression.charAt()










        
//        for (int i = 0; i < expression.length(); i++){
//
//            var symbol = expression.charAt(i);
//
//            switch (symbol){
//                case '+':
//                    if(expression.charAt(i - 1) == ' '){
//                        operator = "+";
//                    }
//                    else{
//                        throw new ParseException("Wrong sequence of numbers");
//                    }
//                    continue;
//                case '-':
//                    if(expression.charAt(i - 1) == ' '){
//                        operator = "-";
//                    }
//                    else{
//                        throw new ParseException("Wrong sequence of numbers");
//                    }
//                    continue;
//                default:
//                    if(symbol >= '1' && symbol <= '9'){
//
//                        sb.append(symbol);
//
//                    }else if(symbol == ' '){
//
//                        if(operand1 != null && operand2 != null && operatorExists){
//
//                            switch (operator){
//                                case "+":
//                                    sum +=
//                            }
//
//                        }
//
//
//                    }
//
//            }
//
//
////            if(expression.charAt(i) != ' ' &&
////                    (expression.charAt(i) <= '9' && expression.charAt(i) >= '1'
////                            || expression.charAt(i) >= '-')){
////
////                sb.append(sb.append(expression.charAt(i)));
////
////            }else if(expression.charAt(i) == ' '){
////
////                if(operand1 == null){
////                    operand1 = Integer.parseInt(sb.toString());
////                }
////                if(operand2 == null){
////
////                }
////
////
////
////            }else if( (expression.charAt(i) == '+' || expression.charAt(i+1) == '-'))
//
//        }




        return 0;
    }
}

package expression;

import java.util.Objects;

public class Variable implements Expression, DoubleExpression, TripleExpression{

    private String variable;

    Variable(String variable){

        this.variable = variable;

    }


    @Override
    public int evaluate(int x) {
        return x;
    }


    @Override
    public double evaluate(double x) {
        return x;
    }

    @Override
    public int evaluate(int x, int y, int z) {

        switch (variable) {
            case "x":

                return x;

            case "y":

                return y;

            case "z":

                return z;
        }


        //replace this
        return x;
    }


}

package expression;

public class Const implements Expression, DoubleExpression, TripleExpression{

    private Number number;


    Const(Number number){
        this.number = number;
    }

    @Override
    public int evaluate(int x) {
        return number.intValue();
    }

    @Override
    public double evaluate(double x) {
        return number.doubleValue();
    }

    @Override
    public int evaluate(int x, int y, int z) {
        return number.intValue();
    }


}

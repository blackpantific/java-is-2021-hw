package expression;

public class Multiply extends BinaryOperation{
    Multiply(Expression firstOp, Expression secondOp) {
        super(firstOp, secondOp);
    }


    @Override
    public int evaluate(int x) {
        return ((Expression)getFirstOperand()).evaluate(x) * ((Expression)getSecondOperand()).evaluate(x);
    }

    @Override
    public double evaluate(double x) {
        return ((DoubleExpression)getFirstOperand()).evaluate(x) * ((DoubleExpression)getSecondOperand()).evaluate(x);
    }

    @Override
    public int evaluate(int x, int y, int z) {
        return ((TripleExpression)getFirstOperand()).evaluate(x, y, z)
                * ((TripleExpression)getSecondOperand()).evaluate(x, y, z);
    }
}

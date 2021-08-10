package expression;

public class Divide extends BinaryOperation{

    Divide(Expression firstOp, Expression secondOp) {
        super(firstOp, secondOp);
    }


    @Override
    public int evaluate(int x) {
        return getFirstOperand().evaluate(x) / getSecondOperand().evaluate(x);
    }

    @Override
    public double evaluate(double x) {
        return 0;
    }


    @Override
    public int evaluate(int x, int y, int z) {
        return 0;
    }
}

package expression;

public class Subtract extends BinaryOperation{

    Subtract(Expression firstOp, Expression secondOp) {
        super(firstOp, secondOp);
    }

    @Override
    public double evaluate(double x) {
        return 0;
    }

    @Override
    public int evaluate(int x) {
        return getFirstOperand().evaluate(x) - getSecondOperand().evaluate(x);
    }

    @Override
    public int evaluate(int x, int y, int z) {
        return 0;
    }
}

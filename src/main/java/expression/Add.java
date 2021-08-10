package expression;

public class Add extends BinaryOperation {


    Add(Expression firstOp, Expression secondOp) {
        super(firstOp, secondOp);
    }

    @Override
    public int evaluate(int x) {
        return getFirstOperand().evaluate(x) + getSecondOperand().evaluate(x);
    }

    @Override
    public double evaluate(double x) {
        return getFirstOperand().evaluate(x) + getSecondOperand().evaluate(x);
    }

    @Override
    public int evaluate(int x, int y, int z) {
        return 0;
    }
}

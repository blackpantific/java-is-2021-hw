package expression;

public abstract class BinaryOperation implements  Expression, DoubleExpression, TripleExpression{

    private CommonExpression firstOperand;
    private CommonExpression secondOperand;

    BinaryOperation(CommonExpression firstOp, CommonExpression secondOp){

        this.firstOperand = firstOp;
        this.secondOperand = secondOp;

    }

    public CommonExpression getFirstOperand() {
        return firstOperand;
    }

    public void setFirstOperand(Expression firstOperand) {
        this.firstOperand = firstOperand;
    }

    public CommonExpression getSecondOperand() {
        return secondOperand;
    }

    public void setSecondOperand(Expression secondOperand) {
        this.secondOperand = secondOperand;
    }
}

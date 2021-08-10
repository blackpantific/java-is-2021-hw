package expression;

public abstract class BinaryOperation implements  CommonExpression{

    private Expression firstOperand;
    private Expression secondOperand;

    BinaryOperation(Expression firstOp, Expression secondOp){

        this.firstOperand = firstOp;
        this.secondOperand = secondOp;

    }

    public CommonExpression getFirstOperand() {
        return (CommonExpression)firstOperand;
    }


    public CommonExpression getSecondOperand() {
        return (CommonExpression)secondOperand;
    }

}
